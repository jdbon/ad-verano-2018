package hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import entity.ArticuloEntity;
import entity.PedidoEntity;



public class HibernateUtil
{
    private static final SessionFactory sessionFactory;

    static
    {
        try
        {
             AnnotationConfiguration config = new AnnotationConfiguration();
             config.addAnnotatedClass(ArticuloEntity.class);
             config.addAnnotatedClass(ArticuloEntity.class);
             
             
             
             
             sessionFactory = config.buildSessionFactory();                         
        }
        catch (Throwable ex)
        {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
 
    public static SessionFactory getSessionFactory()
    {
        return sessionFactory;
    }
}
