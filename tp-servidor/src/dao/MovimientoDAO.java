package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entity.MovimientoABEntity;
import entity.MovimientoAjusteEntity;
import hibernate.HibernateUtil;
import negocio.MovimientoAB;
import negocio.MovimientoAjuste;

public class MovimientoDAO {
	
	private static MovimientoDAO instancia;
	
	private MovimientoDAO() {}
	
	public static MovimientoDAO getInstancia() {
		if(instancia == null)
			instancia = new MovimientoDAO();
		return instancia;
		
	}
	
	public void save(MovimientoAB mab){
		MovimientoABEntity mABe = this.toEntity(mab);
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();
		s.save(mABe);
		s.getTransaction().commit();
		s.flush();
		s.close();
		
	}
	
	public void save(MovimientoAjuste ma){
		MovimientoAjusteEntity mae = this.toEntity(ma);
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();
		s.save(mae);
		s.getTransaction().commit();
		s.flush();
		s.close();

	}
	
	public MovimientoABEntity toEntity(MovimientoAB mab){
		
			MovimientoABEntity mABe = new MovimientoABEntity();
			mABe.setCantidad(mab.getCantidad());
			mABe.setNroMovimiento(mab.getNroMovimiento());
			mABe.setTipo(mab.getTipo());
			
			return mABe;
	}
	
	public MovimientoAjusteEntity toEntity(MovimientoAjuste ma){
			
			MovimientoAjusteEntity mae = new MovimientoAjusteEntity();
			mae.setCantidad(ma.getCantidad());
			mae.setNroMovimiento(ma.getNroMovimiento());
			mae.setTipo(ma.getTipo());
			
			return mae;
	}
	

}
