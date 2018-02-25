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
             config.addAnnotatedClass(FacturaEntity.class);
             config.addAnnotatedClass(ArticuloEntity.class);
             config.addAnnotatedClass(OrdenDeCompraEntity.class);
             config.addAnnotatedClass(ArticuloEntity.class);
             config.addAnnotatedClass(MovimientoABEntity.class);
             config.addAnnotatedClass(MovimientoAjusteEntity.class);
             config.addAnnotatedClass(MovimientoEntity.class);
             config.addAnnotatedClass(LoteEntity.class);

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
