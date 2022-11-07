
package dataaccess;


import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import models.Role;
import models.User;

public class RoleDB {
    public List<Role> getAll() throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        
        try {
            //get list of all users
            List<Role> roles = em.createNamedQuery("Role.findAll", Role.class).getResultList();
            return roles;
        } finally {
            em.close();
        }
    }
    
     public Role get(int id) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        
        try {
            Role role = em.find(Role.class, id);
            return role;
        } finally { 
            em.close();
        }
    }
    
    public void insert(Role role) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();

        try {
            trans.begin();
            em.persist(role);
            trans.commit();
        } catch (Exception e) {
            trans.rollback();
        } finally {
           em.close();
        }
    }
    
     public void update(Role role) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();

        try {
            trans.begin();
            em.merge(role);
            trans.commit();
        } catch (Exception e) {
            trans.rollback();
        } finally {
           em.close();
        }
    }

      public void delete(Role role) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();

        try {
            trans.begin();
            em.remove(em.merge(role));
            trans.commit();
        } catch (Exception e) {
            trans.rollback();
        } finally {
           em.close();
        }
    }
}