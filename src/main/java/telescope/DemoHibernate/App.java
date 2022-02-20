package telescope.DemoHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
	private static SessionFactory sessionFactory;
    public static void main( String[] args )
    {
        Tree tree1 = new Tree();
        // tree1.setNo(2);
        tree1.setName("Nck");
        tree1.setAge(42);
        tree1.setHeight(6.5);
        tree1.setPlace("Mumbai");
        
        try {
        	Configuration configuration = new Configuration();
        	sessionFactory = configuration.configure("hibernate.cfg.xml").addAnnotatedClass(Tree.class).buildSessionFactory();
        	Session session = sessionFactory.openSession();
        	Transaction tx =session.beginTransaction();
	        session.save(tree1);
	        tx.commit();
//        	String sql = "select version()";
//        	String result = (String) session.createNativeQuery(sql).getSingleResult();
//        	System.out.println(result);
        	session.close();
        } catch (Exception ex) {
        	System.out.println("Check error " + ex.getMessage());
        }
//        Session session = sf.openSession();
//        Transaction tx =session.beginTransaction();
//        session.save(tree1);
//        tx.commit();
        
    }
}
