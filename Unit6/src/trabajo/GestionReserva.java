package trabajo;

import java.util.TreeSet;

public class GestionReserva {
	private TreeSet <Reserva> listaReservas;
	
	GestionReserva(){
		listaReservas = new TreeSet<>();
	}
	
	GestionReserva(TreeSet <Reserva> listaReservas){
		this.listaReservas = listaReservas;
	}
	
	public void anadirReserva(Reserva reserva) {
		if (listaReservas.add(reserva)) {
			System.out.println("Se ha anadido la reserva correctamente");
		} else {
			System.out.println("No se ha podido anadir la reserva porque ya habia una reserva igual registrada");
		}
	}
	
	public boolean buscarReserva(int codigo) {
		boolean reservaEncontrada = false;
		
		for (Reserva re : listaReservas) {
			if (re.getCodigo() == codigo) {
				System.out.println(re.toString());
				reservaEncontrada = true;
			}
		}
		
		return reservaEncontrada;
	}
	
	public void listarReservas() {
		if (!listaReservas.isEmpty()) {
			for (Reserva re : listaReservas) {
				System.out.println(re.toString());
			}
		} else {
			System.out.println("No hay ninguna reserva registrada");
		}
	}
	
	public boolean modificarReserva(int codigo, String fechaEntrada, String fechaSalida) throws ImpossibleDepartureDateException {
		boolean fechasModificadas = false;
		
		for (Reserva re : listaReservas) {
			if (re.getCodigo() == codigo) {
				re.setFechaEntrada(fechaEntrada);
				re.setFechaSalida(fechaSalida);
				fechasModificadas = true;
			}
		}
		
		return fechasModificadas;
	}
	
	public boolean eliminarReserva(int codigo) {
		return listaReservas.removeIf(reserva -> reserva.getCodigo() == codigo);
	}
}
