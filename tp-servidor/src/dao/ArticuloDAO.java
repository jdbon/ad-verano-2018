package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entity.ArticuloEntity;
import entity.LoteEntity;
import entity.MovimientoEntity;
import excepcion.ArticuloException;
import hibernate.HibernateUtil;
import negocio.Articulo;
import negocio.Lote;
import negocio.Movimiento;


public class ArticuloDAO {

	private static ArticuloDAO instancia;
	
	private ArticuloDAO(){
		
	}
	
	public static ArticuloDAO getInstancia(){
		if(instancia == null)
			instancia = new ArticuloDAO();
		return instancia;
	}
	
	public ArticuloEntity toEntity(Articulo art){
		ArticuloEntity artE = new ArticuloEntity();
		artE.setCantidadOrdenDeCompra(art.getCantidadOrdenDeCompra());
		artE.setCantidadReservada(art.getCantidadReservada());
		artE.setCodigoBarra(art.getCodigoBarra());
		artE.setDescripcion(art.getDescripcion());		
		for(Lote lote: art.getLotes()) {
			LoteEntity le = lote.toEntity(lote);
			artE.getLotes().add(le);
		}
		for(Movimiento movimiento: art.getMovimientos()) {
/*			MovimientoEntity movEnt = movimiento.toEntity(movimiento); //TODO metodo toEntity
			artE.getMovimientos().add(movEnt);*/
		}
		artE.setPresentacion(art.getPresentacion());
		artE.setPrecioVenta(art.getPrecioVenta());
		artE.setTamaño(art.getTamaño());
		artE.setUnidad(art.getUnidad());
		return artE;
	}
	
	public Articulo toNegocio(ArticuloEntity artE){
		Articulo art = new Articulo();
		art.setCantidadOrdenDeCompra(artE.getCantidadOrdenDeCompra());
		art.setCantidadReservada(artE.getCantidadReservada());
		art.setCodigoBarra(artE.getCodigoBarra());
		art.setDescripcion(artE.getDescripcion());
//		for(LoteEntity loteEnt: artE.getLotes()) {
//			Lote lote = new Lote();
//			lote.setNroLote(loteEnt.getNroLote());
//			lote.setVencimiento(loteEnt.getVencimiento());
//			art.getLotes().add(lote);
//		}
//		for(MovimientoEntity movEnt: artE.getMovimientos()) {
///*			Movimiento movimiento = new Movimiento();
//			movimiento.setArticulo(movEnt.getArticulo());
//			art.getMovimientos().add(movimiento);*/
//		}
		art.setPrecioVenta(artE.getPrecioVenta());
		art.setPresentacion(artE.getPresentacion());
		art.setTamaño(artE.getTamaño());
		art.setUnidad(artE.getUnidad());
		return art;
	}

	public Articulo findByID(int idArticulo) throws ArticuloException {
		Articulo resultado;
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.openSession();
		ArticuloEntity auxCliente = (ArticuloEntity) s.createQuery("From ClienteEntity c where c.numero = ?").setInteger(0, idArticulo).uniqueResult();
		s.close();
		if(auxCliente == null) {
				throw new ArticuloException("No existe un cliente con el id " + idArticulo);
		}
		resultado = this.toNegocio(auxCliente);
		return resultado;
	}
}
