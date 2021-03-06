
package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entity.ArticuloEntity;
import entity.LoteEntity;
import entity.MovimientoABEntity;
import entity.MovimientoAjusteEntity;
import entity.MovimientoEntity;
import excepcion.ArticuloException;
import hibernate.HibernateUtil;
import negocio.Articulo;
import negocio.Lote;
import negocio.Movimiento;
import negocio.MovimientoAB;
import negocio.MovimientoAjuste;


public class ArticuloDAO {

private static ArticuloDAO instancia;
	
	private ArticuloDAO(){
		
	}
	
	public static ArticuloDAO getInstancia(){
		if(instancia == null)
			instancia = new ArticuloDAO();
		return instancia;
	}
	
	public void update(Articulo a) throws ArticuloException{
		ArticuloEntity pe = this.toEntity(a);
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();
		try {
		s.update(pe);
		s.getTransaction().commit();
		} catch (Exception e) {
			s.getTransaction().rollback();
			throw new ArticuloException("Error al actualizar el Articulo" + pe.getCodigoBarra());
		}
		s.close();
		
	}
	
	public ArticuloEntity toEntity(Articulo art){
		ArticuloEntity artE = new ArticuloEntity();
		//System.out.println("cant OC: " + art.getCantidadOrdenDeCompra());
		artE.setCantidadOrdenDeCompra(art.getCantidadOrdenDeCompra());
		artE.setCantidadReservada(art.getCantidadReservada());
		artE.setCodigoBarra(art.getCodigoBarra());
		artE.setDescripcion(art.getDescripcion());

		/*Set<LoteEntity> lotesE = new HashSet<LoteEntity>();
		artE.setLotes(lotesE);

//		Set<LoteEntity> lotesE = new Set<LoteEntity>();
//		artE.setLotes(lotesE);
		
		//System.out.println("Lotes tama�o: " + art.getLotes().size());
>>>>>>> c0eea729bfd48be0eb3558c3c781d3b301c019b9
		for(Lote lote: art.getLotes()) {
			LoteEntity le = LoteDAO.getInstancia().toEntity(lote);
			artE.getLotes().add(le);
		}
		for(Movimiento m: art.getMovimientos()) {
			if(m instanceof MovimientoAB){
				MovimientoABEntity mabe = new MovimientoABEntity();
				mabe.setCantidad(m.getCantidad());
				mabe.setNroMovimiento(m.getNroMovimiento());
				mabe.setTipo(m.getTipo());
				
				artE.getMovimientos().add(mabe);
			} 
			else if (m instanceof MovimientoAjuste){
				MovimientoAjusteEntity mae = new MovimientoAjusteEntity();
				mae.setAutorizadoPor(((MovimientoAjuste) m).getAutorizadoPor());
				mae.setCantidad(m.getCantidad());
				mae.setDestinoArticulos(((MovimientoAjuste) m).getDestinoArticulos());
				mae.setEncargado(((MovimientoAjuste) m).getEncargado());
				mae.setNroMovimiento(m.getNroMovimiento());
				mae.setTipo(m.getTipo());
				
				artE.getMovimientos().add(mae);
			}
		}
<<<<<<< HEAD
		Set<OrdenDeCompraEntity> odcsE = new HashSet<OrdenDeCompraEntity>();
		artE.setOrdenes(odcsE);
		for(OrdenDeCompra oc: art.getOrdenes()){
			OrdenDeCompraEntity odcE = new OrdenDeCompraEntity();
			odcE.setCantidadReservada(oc.getCantidadReservada());
			odcE.setArtE(artE);
			odcE.setCantidadXcomprar(oc.getCantidadXcomprar());
			odcE.setEstado(oc.getEstado());
			odcE.setFechaCreacion(oc.getFechaCreacion());
			odcE.setFechaRecepcion(oc.getFechaRecepcion());
			odcE.setNroOrdenDeCompra(oc.getNroOrdenDeCompra());
			artE.getOrdenes().add(odcE);
		}*/

		artE.setPresentacion(art.getPresentacion());
		artE.setPrecioVenta(art.getPrecioVenta());
		artE.setTama�o(art.getTama�o());
		artE.setUnidad(art.getUnidad());
		return artE;
	}
	
	public Articulo toNegocio(ArticuloEntity artE){
		Articulo art = new Articulo();
		art.setCantidadOrdenDeCompra(artE.getCantidadOrdenDeCompra());
		art.setCantidadReservada(artE.getCantidadReservada());
		art.setCodigoBarra(artE.getCodigoBarra());
		art.setDescripcion(artE.getDescripcion());
		List<Lote> lotes = new ArrayList<Lote>();
		
		for(LoteEntity loteEnt: artE.getLotes()) {
			Lote lote = new Lote();
			lote.setNroLote(loteEnt.getNroLote());
			lote.setVencimiento(loteEnt.getVencimiento());
			lote.setIdLote(loteEnt.getIdLote());
//			art.getLotes().add(lote);
			lotes.add(lote);
		}
		art.setLotes(lotes);
		List<Movimiento> movimientos = new ArrayList<Movimiento>();
		art.setMovimientos(movimientos);
		
		for(MovimientoEntity movEnt: artE.getMovimientos()) {
			if(movEnt instanceof MovimientoABEntity){
				MovimientoAB mab = new MovimientoAB();
				mab.setCantidad(movEnt.getCantidad());
				mab.setNroMovimiento(movEnt.getNroMovimiento());
				mab.setTipo(movEnt.getTipo());
				
				art.getMovimientos().add(mab);
			}
			else if (movEnt instanceof MovimientoAjusteEntity){
				MovimientoAjuste ma = new MovimientoAjuste();
				ma.setAutorizadoPor(((MovimientoAjusteEntity) movEnt).getAutorizadoPor());
				ma.setCantidad(movEnt.getCantidad());
				ma.setDestinoArticulos(((MovimientoAjusteEntity) movEnt).getDestinoArticulos());
				ma.setEncargado(((MovimientoAjusteEntity) movEnt).getEncargado());
				ma.setTipo(movEnt.getTipo());
				ma.setNroMovimiento(movEnt.getNroMovimiento());
				
				art.getMovimientos().add(ma);
				
			}
			
		}
		art.setPrecioVenta(artE.getPrecioVenta());
		art.setPresentacion(artE.getPresentacion());
		art.setTama�o(artE.getTama�o());
		art.setUnidad(artE.getUnidad());
		return art;
	}


	@SuppressWarnings("unchecked")
	public List<Articulo> findAll() {
		List<Articulo> resultado = new ArrayList<Articulo>();
		Session se = HibernateUtil.getSessionFactory().openSession();
		List<ArticuloEntity> articulos = (List<ArticuloEntity>)se.createQuery("from ArticuloEntity").list();
		se.close();
		for(ArticuloEntity articulo: articulos){
			resultado.add(this.toNegocio(articulo));
		}
		return resultado;
	}
	
	public Articulo findByID(int idArticulo) throws ArticuloException {
		Articulo a;
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.openSession();
		ArticuloEntity auxArticulo = (ArticuloEntity) s.createQuery("From ArticuloEntity ae where ae.codigoBarra = ?").setInteger(0, idArticulo).uniqueResult();
		s.close();
		if(auxArticulo == null) {
				throw new ArticuloException("No existe un Articulo con el id " + idArticulo);
		}
		a = this.toNegocio(auxArticulo);
		return a;
	}
	
	public Articulo findByIDsoloArt(int idArticulo) throws ArticuloException {
		Articulo a;
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.openSession();
		ArticuloEntity auxArticulo = (ArticuloEntity) s.createQuery("From ArticuloEntity ae where ae.codigoBarra = ?").setInteger(0, idArticulo).uniqueResult();
		s.close();
		if(auxArticulo == null) {
				throw new ArticuloException("No existe un Articulo con el id " + idArticulo);
		}
		a = this.toNegocioSoloArt(auxArticulo);
		return a;
	}

	private Articulo toNegocioSoloArt(ArticuloEntity ae) {
		Articulo art = new Articulo();
		art.setCantidadOrdenDeCompra(ae.getCantidadOrdenDeCompra());
		art.setCantidadReservada(ae.getCantidadReservada());
		art.setCodigoBarra(ae.getCodigoBarra());
		art.setDescripcion(ae.getDescripcion());
		art.setPrecioVenta(ae.getPrecioVenta());
		art.setPresentacion(ae.getPresentacion());
		art.setTama�o(ae.getTama�o());
		art.setUnidad(ae.getUnidad());
				
		return art;
	}

	public void updateValores(Articulo a) {
		int idArticulo = a.getCodigoBarra();
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();
		ArticuloEntity ae = (ArticuloEntity) s.createQuery("From ArticuloEntity ae where ae.codigoBarra = ?").setInteger(0, idArticulo).uniqueResult();
		ae.setCantidadOrdenDeCompra(a.getCantidadOrdenDeCompra());
		ae.setCantidadReservada(a.getCantidadReservada());
		
		s.update(ae);
		s.flush();
		s.getTransaction().commit();

		s.close();
		
	}

	

}

