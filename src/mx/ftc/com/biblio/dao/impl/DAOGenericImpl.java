package mx.ftc.com.biblio.dao.impl;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import mx.ftc.com.biblio.dao.DAOGeneric;
import mx.ftc.com.biblio.dao.exception.BiblioException;

public class DAOGenericImpl<T, Id extends Serializable> implements DAOGeneric<T, Id> {

	private Class<T> clase;
//	private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	
//	@PersistenceContext(unitName="persistenceUnit")
//	private EntityManager entityManager;
	protected static EntityManagerFactory factory = Persistence.createEntityManagerFactory("persistenceUnit");

	public DAOGenericImpl(){}
	
	public DAOGenericImpl(Class<T> clase){
		this.clase = clase;
	}

	public T save(T obj) throws BiblioException{
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		try{
			em.persist(obj);
			em.getTransaction().commit();
			em.refresh(obj);		
			return obj;
		} catch(PersistenceException e){				
			e.printStackTrace(System.out);
			throw new BiblioException("Ocurrió un error al guardar, causado por: "+e.getCause());
		} finally{				
			em.close();
		}					
	}

	public T update(T obj)throws BiblioException{
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		try{
			T resultado = null;
			resultado = em.merge(obj);		
			em.getTransaction().commit();
			return resultado;
		}catch(PersistenceException e){
			e.printStackTrace(System.out);
			throw new BiblioException("Ocurrió una excepción en la unidad de persistencia, revise el log de operaciones para más detalles.",e.getCause());
		}finally{
			em.close();
		}
	}

	public void delete(T obj) throws BiblioException{
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		try{
			if(em.find(obj.getClass() , obj)!=null){
				System.out.println("=====> Object found, it exists in the unit persistence as " + obj.toString());
				em.remove(obj);
			}else{
				System.out.println("=====> The object does not exists in the unit persistence "+obj.toString());
			}
			em.getTransaction().commit();
		}catch(PersistenceException e){
			e.printStackTrace(System.out);
			throw new BiblioException("Ocurrió un error al eliminar, causado por: "+e.getCause());
		}finally{
			em.close();
		}
	}

	public boolean contains(T obj) throws BiblioException{
		EntityManager em = factory.createEntityManager();
		try{
			return em.contains(obj);
		}catch(PersistenceException e){
			e.printStackTrace(System.out);
			throw new BiblioException("Ocurrió un error al ejecutar contains(), causado por: "+e.getCause());
		}finally{
			em.close();
		}
	}

	public List<T> findAll()throws BiblioException{
		EntityManager em = factory.createEntityManager();
		try{
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT obj FROM ").append(clase.getSimpleName()).append(" obj");
			TypedQuery<T> query = em.createQuery(sql.toString(), clase);
			return query.getResultList();
		}catch(PersistenceException e){
			e.printStackTrace(System.out);
			throw new BiblioException("Ocurrió un error en findAll(), causado por: "+e.getCause());
		}finally{
			em.close();
		}
	}

	public T findById(String id)throws BiblioException{
		EntityManager em = factory.createEntityManager();
		try{
			return em.find(clase, id);
		}catch(PersistenceException e){
			e.printStackTrace(System.out);
			throw new BiblioException("Ocurrió un error en findById(), causado por: "+e.getCause());
		}finally{
			em.close();
		}
	}

	/**
	 * Ejecuta un Query JQPL obteniendo una Lista con el resultado del Query
	 * 
	 * @param jpql
	 *            Query en formato JQPL
	 * @param values
	 *            Parametros del Query
	 * @return Lista con el resultado del Query
	 * @see javax.persistence.Query
	 */
	//@SuppressWarnings("unchecked")
	protected List<T> executeQuery(String jpql, Object... values)throws BiblioException{
		EntityManager em = factory.createEntityManager();
		try{
			TypedQuery<T> query = em.createQuery(jpql, clase);
			int iParametro = 1;
			for (Object object : values) {
				query.setParameter(iParametro++, object);				
			}
			return query.getResultList();
		}catch(Exception e){
			e.printStackTrace(System.out);
			throw new BiblioException("Ocurrió un error en executeQuery(), causado por: "+e.getCause());
		}finally{
			em.close();
		}
	}
	
	/**
	 * Ejecuta un Query Nativo
	 * @param sql Sentencia a ejecutar. Se usa executeUpdate
	 */
	protected int executeNativeQuery(String sql)throws BiblioException{
		EntityManager em = factory.createEntityManager();
		try{
			Query query = em.createNativeQuery(sql);
			return query.executeUpdate();
		}catch(Exception e){
			e.printStackTrace(System.out);
			throw new BiblioException("Ocurrió un error en executeNativeQuery(), causado por: "+e.getCause());
		}finally{
			em.close();
		}
	}
	
	
	public Class<T> getClase() {
		return clase;
	}
	
	public void setClase(Class<T> clase) {
		this.clase = clase;
	}
	
}
