package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaMain {

	public static void main(String[] args) {
        //��ƼƼ �Ŵ��� ���丮 ����
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager(); //��ƼƼ �Ŵ��� ���� 
        
        //code
        
        em.close();
        emf.close();
	}

}
