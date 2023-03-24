package pe.nisum.app.web.model;

public class WebResponseEntity<T> {

	private String trackingId;
	private String mensaje;
	private T data;

	public WebResponseEntity() {
	}

	public String getTrackingId() {
		return this.trackingId;
	}


	public String getMensaje() {
		return this.mensaje;
	}


	public T getData() {
		return this.data;
	}

	public void setTrackingId(String trackingId) {
		this.trackingId = trackingId;
	}


	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}


	public void setData(T data) {
		this.data = data;
	}

	public boolean equals(Object o) {
		if(o == this) {
			return true;
		}
		else if(!(o instanceof WebResponseEntity)) {
			return false;
		}
		else {
			WebResponseEntity<?> other = (WebResponseEntity)o;
			if(!other.canEqual(this)) {
				return false;
			}
			else {
				label71:
				{
					Object this$trackingId = this.getTrackingId();
					Object other$trackingId = other.getTrackingId();
					if(this$trackingId == null) {
						if(other$trackingId == null) {
							break label71;
						}
					}
					else if(this$trackingId.equals(other$trackingId)) {
						break label71;
					}

					return false;
				}

				label57:
				{
					Object this$mensaje = this.getMensaje();
					Object other$mensaje = other.getMensaje();
					if(this$mensaje == null) {
						if(other$mensaje == null) {
							break label57;
						}
					}
					else if(this$mensaje.equals(other$mensaje)) {
						break label57;
					}

					return false;
				}

				Object this$data = this.getData();
				Object other$data = other.getData();
				if(this$data == null) {
					return other$data == null;
				}
				else return this$data.equals(other$data);
			}
		}
	}

	protected boolean canEqual(Object other) {
		return other instanceof WebResponseEntity;
	}

	public int hashCode() {
		boolean PRIME = true;
		int result = 1;
		Object $trackingId = this.getTrackingId();
		result = result * 59 + ($trackingId == null ? 43 : $trackingId.hashCode());
		Object $message = this.getMensaje();
		result = result * 59 + ($message == null ? 43 : $message.hashCode());
		Object $data = this.getData();
		result = result * 59 + ($data == null ? 43 : $data.hashCode());
		return result;
	}

	public String toString() {
		return "WebResponseEntity(trackingId=" + this.getTrackingId() + ", mensaje=" + this.getMensaje() + ", data=" + this.getData() + ")";
	}

}
