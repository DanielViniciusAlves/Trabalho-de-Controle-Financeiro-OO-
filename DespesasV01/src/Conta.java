import java.util.Stack;

public class Conta {
	private boolean status;
	
	// Get
	public boolean getStatus() {
		return status;
	}
			
	// Set
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	public void CriarConta() {
		status = true;
	}
	public void ApagarConta() {
		status = false;
	}
}