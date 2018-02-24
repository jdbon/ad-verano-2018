package hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import entity.*;



public class HibernateUtil
{
    private static final SessionFactory sessionFactory;

    static
    {
        try
        {
             AnnotationConfiguration config = new AnnotationConfiguration();
             //mapeados
             
             config.addAnnotatedClass(ClienteEntity.class);    
             config.addAnnotatedClass(PedidoEntity.class);
             config.addAnnotatedClass(ItemPedidoEntity.class);
             
             
             
             //faltan mapear
             //config.addAnnotatedClass(ArticuloEntity.class);
             //config.addAnnotatedClass(FacturaEntity.class);
             
             
             
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
