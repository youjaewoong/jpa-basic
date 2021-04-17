package hellojpa;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {

	public static void main(String[] args) {
        //��ƼƼ �Ŵ��� ���丮 ����
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        
        EntityManager em = emf.createEntityManager(); //��ƼƼ �Ŵ��� ���� 
        
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
        	//insert
        	/*
        	Member member = new Member();
        	member.setId(2L);
        	member.setName("HelloB");
        	em.persist(member);
        	*/
        	
        	//Member findMember = em.find(Member.class, 1L);
        	//select
        	/*
        	System.out.println("findMember.id=" + findMember.getId());
        	System.out.println("findMember.name=" + findMember.getName());
        	*/
        	
        	//delete
        	//em.remove(findMember);
        	
        	//modefiy
        	//findMember.setName("HelloJPA");
        	
        	//JPQL
        	List<Member> result = em.createQuery("select m from Member as m", Member.class)
        			.setFirstResult(5)	
        			.setMaxResults(8)
        			.getResultList();
        	
        	result.forEach(e -> System.out.println(e.getName()));
        	
        	tx.commit();
        }catch(Exception e) {
        	tx.rollback();
        }finally {
        	em.close();
        }
        emf.close();
	}

}
