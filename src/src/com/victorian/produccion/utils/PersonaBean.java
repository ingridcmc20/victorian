package src.com.victorian.produccion.utils;

import java.sql.Date;
import java.sql.Time;

public class PersonaBean {
	private String co_empresa;
	private String co_cliente;
	private Integer co_tipocontacto;
	private String apepat;
	private String co_tipodocumento;
	private String nu_documento;
	private String de_direccion;
	private String de_cargo;
	private String co_tipo_cliente;

	private String co_oficina;
	private String codpersonajuridica;
	private String ruc;

	private String codpersonanatural;
	private String apemat;
	private String nombre;
	
	private String co_producto;
	private String co_convenio_marco;
	private String co_tipo_convenio;
	private String co_moneda_convenio;
	private Date fe_inicio_convenio;
	private Date fe_final_convenio;
	private String va_prestamo_maximo;
	private String es_registro;
	private Date fe_crea_registro;
	private Integer id_crea_registro;
	private Time ho_crea_registro;
	private Date fe_mod_registro;
	private Integer id_mod_registro;
	private Time ho_mod_registro;
	private Integer co_convenio;
	private String co_tasa;
	private String ti_tasa;
	private Double va_tasa;
	private String co_empleado;
	private String co_tipo_representante_legal;
	private String co_tipo_gestor;
	private String nu_convenio_empleados;
	private String nu_telef;
	private String co_representante_legal;
	private String fl_firma;
	private String es_representante_legal;
	private String de_mail;
	
	
	
	public String getCo_representante_legal() {
		return co_representante_legal;
	}

	public void setCo_representante_legal(String co_representante_legal) {
		this.co_representante_legal = co_representante_legal;
	}

	public Time getHo_crea_registro() {
		return ho_crea_registro;
	}

	public void setHo_crea_registro(Time ho_crea_registro) {
		this.ho_crea_registro = ho_crea_registro;
	}

	public Time getHo_mod_registro() {
		return ho_mod_registro;
	}

	public void setHo_mod_registro(Time ho_mod_registro) {
		this.ho_mod_registro = ho_mod_registro;
	}

	public String getNu_telef() {
		return nu_telef;
	}

	public void setNu_telef(String nu_telef) {
		this.nu_telef = nu_telef;
	}

	public String getCo_empleado() {
		return co_empleado;
	}

	public void setCo_empleado(String co_empleado) {
		this.co_empleado = co_empleado;
	}

	public String getCo_tipo_gestor() {
		return co_tipo_gestor;
	}

	public void setCo_tipo_gestor(String co_tipo_gestor) {
		this.co_tipo_gestor = co_tipo_gestor;
	}

	public String getNu_convenio_empleados() {
		return nu_convenio_empleados;
	}

	public void setNu_convenio_empleados(String nu_convenio_empleados) {
		this.nu_convenio_empleados = nu_convenio_empleados;
	}

	public String getCo_tasa() {
		return co_tasa;
	}

	public void setCo_tasa(String co_tasa) {
		this.co_tasa = co_tasa;
	}

	public String getTi_tasa() {
		return ti_tasa;
	}

	public void setTi_tasa(String ti_tasa) {
		this.ti_tasa = ti_tasa;
	}

	public Double getVa_tasa() {
		return va_tasa;
	}

	public void setVa_tasa(Double va_tasa) {
		this.va_tasa = va_tasa;
	}

	public Integer getCo_convenio() {
		return co_convenio;
	}

	public void setCo_convenio(Integer co_convenio) {
		this.co_convenio = co_convenio;
	}

	public String getCo_producto() {
		return co_producto;
	}

	public void setCo_producto(String co_producto) {
		this.co_producto = co_producto;
	}

	public String getCo_convenio_marco() {
		return co_convenio_marco;
	}

	public void setCo_convenio_marco(String co_convenio_marco) {
		this.co_convenio_marco = co_convenio_marco;
	}

	public String getCo_tipo_convenio() {
		return co_tipo_convenio;
	}

	public void setCo_tipo_convenio(String co_tipo_convenio) {
		this.co_tipo_convenio = co_tipo_convenio;
	}

	public String getCo_moneda_convenio() {
		return co_moneda_convenio;
	}

	public void setCo_moneda_convenio(String co_moneda_convenio) {
		this.co_moneda_convenio = co_moneda_convenio;
	}

	public Date getFe_inicio_convenio() {
		return fe_inicio_convenio;
	}

	public void setFe_inicio_convenio(Date fe_inicio_convenio) {
		this.fe_inicio_convenio = fe_inicio_convenio;
	}

	public Date getFe_final_convenio() {
		return fe_final_convenio;
	}

	public void setFe_final_convenio(Date fe_final_convenio) {
		this.fe_final_convenio = fe_final_convenio;
	}

	public String getVa_prestamo_maximo() {
		return va_prestamo_maximo;
	}

	public void setVa_prestamo_maximo(String va_prestamo_maximo) {
		this.va_prestamo_maximo = va_prestamo_maximo;
	}

	public String getEs_registro() {
		return es_registro;
	}

	public void setEs_registro(String es_registro) {
		this.es_registro = es_registro;
	}

	public Date getFe_crea_registro() {
		return fe_crea_registro;
	}

	public void setFe_crea_registro(Date fe_crea_registro) {
		this.fe_crea_registro = fe_crea_registro;
	}

	public Integer getId_crea_registro() {
		return id_crea_registro;
	}

	public void setId_crea_registro(Integer id_crea_registro) {
		this.id_crea_registro = id_crea_registro;
	}

	public Date getFe_mod_registro() {
		return fe_mod_registro;
	}

	public void setFe_mod_registro(Date fe_mod_registro) {
		this.fe_mod_registro = fe_mod_registro;
	}

	public Integer getId_mod_registro() {
		return id_mod_registro;
	}

	public void setId_mod_registro(Integer id_mod_registro) {
		this.id_mod_registro = id_mod_registro;
	}

	public String getCo_empresa() {
		return co_empresa;
	}

	public void setCo_empresa(String co_empresa) {
		this.co_empresa = co_empresa;
	}

	public String getCo_cliente() {
		return co_cliente;
	}

	public void setCo_cliente(String co_cliente) {
		this.co_cliente = co_cliente;
	}

	public Integer getCo_tipocontacto() {
		return co_tipocontacto;
	}

	public void setCo_tipocontacto(Integer co_tipocontacto) {
		this.co_tipocontacto = co_tipocontacto;
	}

	public String getApepat() {
		return apepat;
	}

	public void setApepat(String apepat) {
		this.apepat = apepat;
	}

	public String getCo_tipodocumento() {
		return co_tipodocumento;
	}

	public void setCo_tipodocumento(String co_tipodocumento) {
		this.co_tipodocumento = co_tipodocumento;
	}

	public String getNu_documento() {
		return nu_documento;
	}

	public void setNu_documento(String nu_documento) {
		this.nu_documento = nu_documento;
	}

	public String getDe_direccion() {
		return de_direccion;
	}

	public void setDe_direccion(String de_direccion) {
		this.de_direccion = de_direccion;
	}

	public String getCo_tipo_cliente() {
		return co_tipo_cliente;
	}

	public void setCo_tipo_cliente(String co_tipo_cliente) {
		this.co_tipo_cliente = co_tipo_cliente;
	}

	public String getCo_oficina() {
		return co_oficina;
	}

	public void setCo_oficina(String co_oficina) {
		this.co_oficina = co_oficina;
	}

	public String getCodpersonajuridica() {
		return codpersonajuridica;
	}

	public void setCodpersonajuridica(String codpersonajuridica) {
		this.codpersonajuridica = codpersonajuridica;
	}

	public String getRuc() {
		return ruc;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

	public String getCodpersonanatural() {
		return codpersonanatural;
	}

	public void setCodpersonanatural(String codpersonanatural) {
		this.codpersonanatural = codpersonanatural;
	}

	public String getApemat() {
		return apemat;
	}

	public void setApemat(String apemat) {
		this.apemat = apemat;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getFl_firma() {
		return fl_firma;
	}

	public void setFl_firma(String fl_firma) {
		this.fl_firma = fl_firma;
	}

	public String getEs_representante_legal() {
		return es_representante_legal;
	}

	public void setEs_representante_legal(String es_representante_legal) {
		this.es_representante_legal = es_representante_legal;
	}

	public String getCo_tipo_representante_legal() {
		return co_tipo_representante_legal;
	}

	public void setCo_tipo_representante_legal(String co_tipo_representante_legal) {
		this.co_tipo_representante_legal = co_tipo_representante_legal;
	}

	public String getDe_mail() {
		return de_mail;
	}

	public void setDe_mail(String de_mail) {
		this.de_mail = de_mail;
	}

	public String getDe_cargo() {
		return de_cargo;
	}

	public void setDe_cargo(String de_cargo) {
		this.de_cargo = de_cargo;
	}
	
	

}
