package com.victorian.produccion.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @author IngridMC Fecha cambio: 01/02/2017 Descripcion: Permite guardar la
 *         información del usuario.
 */
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;
	public int id_usuario;
	private String dni;
	private String nombre;
	private String apellido_paterno;
	private String apellido_materno;
	private String login;
	private String password;
	private String email;
	private String direccion;
	private Boolean estado;
	private Date fecha_acceso;
	private Date fecha_registro;
	private Date fecha_mod;
	private int cod_perfil;
	private Boolean es_nuevo;
	private Date fecha_cambio_password;
	private String fecha_cambio_pass;
	private Integer id_empresa;
	private Integer id_proyecto;
	private Integer id_cargo;
	private byte[] imagen;
	private Date fecha_cese;
	private String motivo_cese;
	private String funcion;
	private String rpm;
	private String rpc;
	private String telefono;
	private String codigoBanco; // el de ejecutivo
	private String codigoBancoSupervisor; // el de supervisor
	private String codigo_quality; // codigo del sistema quality
	private Integer dias_vacaciones;
	private Integer dias_descanso;
	private Integer idproducto;
	private String producto_principal;
	private String otros_productos;
	private String negocio_asignado;

	private String nombre_completo;
	private boolean dotacion;
	private String desEmpresa;

	public Usuario() {
	}

	public Usuario(Integer id_usuario) {
		this.id_usuario = id_usuario;
	}

	public Integer getId_cargo() {
		return id_cargo;
	}

	public void setId_cargo(Integer id_cargo) {
		this.id_cargo = id_cargo;
	}

	public Integer getId_empresa() {
		return id_empresa;
	}

	public void setId_empresa(Integer id_empresa) {
		this.id_empresa = id_empresa;
	}

	public Integer getId_proyecto() {
		return id_proyecto;
	}

	public void setId_proyecto(Integer id_proyecto) {
		this.id_proyecto = id_proyecto;
	}

	public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}

	public Usuario(String login, String password) {
		this.login = login;
		this.password = password;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido_paterno() {
		return apellido_paterno;
	}

	public void setApellido_paterno(String apellido_paterno) {
		this.apellido_paterno = apellido_paterno;
	}

	public String getApellido_materno() {
		return apellido_materno;
	}

	public void setApellido_materno(String apellido_materno) {
		this.apellido_materno = apellido_materno;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public Date getFecha_acceso() {
		return fecha_acceso;
	}

	public void setFecha_acceso(Date fecha_acceso) {
		this.fecha_acceso = fecha_acceso;
	}

	public Date getFecha_registro() {
		return fecha_registro;
	}

	public void setFecha_registro(Date fecha_registro) {
		this.fecha_registro = fecha_registro;
	}

	public Date getFecha_mod() {
		return fecha_mod;
	}

	public void setFecha_mod(Date fecha_mod) {
		this.fecha_mod = fecha_mod;
	}

	public int getCod_perfil() {
		return cod_perfil;
	}

	public void setCod_perfil(int cod_perfil) {
		this.cod_perfil = cod_perfil;
	}

	public Boolean getEs_nuevo() {
		return es_nuevo;
	}

	public void setEs_nuevo(Boolean es_nuevo) {
		this.es_nuevo = es_nuevo;
	}

	public Date getFecha_cambio_password() {
		return fecha_cambio_password;
	}

	public void setFecha_cambio_password(Date fecha_cambio_password) {
		this.fecha_cambio_password = fecha_cambio_password;
	}

	public String getFecha_cambio_pass() {
		return fecha_cambio_pass;
	}

	public void setFecha_cambio_pass(String fecha_cambio_pass) {
		this.fecha_cambio_pass = fecha_cambio_pass;
	}

	public String getNombre_completo() {
		String apellidos = "";
		if (getApellido_paterno() != null)
			apellidos += " " + getApellido_paterno();

		if (getApellido_materno() != null)
			apellidos += " " + getApellido_materno();

		nombre_completo = (apellidos + " " + getNombre()).trim();
		return nombre_completo;
	}

	public byte[] getImagen() {
		return imagen;
	}

	public void setImagen(byte[] imagen) {
		this.imagen = imagen;
	}

	public Date getFecha_cese() {
		return fecha_cese;
	}

	public void setFecha_cese(Date fecha_cese) {
		this.fecha_cese = fecha_cese;
	}

	public String getMotivo_cese() {
		return motivo_cese;
	}

	public void setMotivo_cese(String motivo_cese) {
		this.motivo_cese = motivo_cese;
	}

	public String getFuncion() {
		return funcion;
	}

	public void setFuncion(String funcion) {
		this.funcion = funcion;
	}

	public String getRpm() {
		return rpm;
	}

	public void setRpm(String rpm) {
		this.rpm = rpm;
	}

	public String getRpc() {
		return rpc;
	}

	public void setRpc(String rpc) {
		this.rpc = rpc;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCodigoBanco() {
		return codigoBanco;
	}

	public void setCodigoBanco(String codigoBanco) {
		this.codigoBanco = codigoBanco;
	}

	public String getCodigoBancoSupervisor() {
		return codigoBancoSupervisor;
	}

	public void setCodigoBancoSupervisor(String codigoBancoSupervisor) {
		this.codigoBancoSupervisor = codigoBancoSupervisor;
	}

	public String getCodigo_quality() {
		return codigo_quality;
	}

	public void setCodigo_quality(String codigo_quality) {
		this.codigo_quality = codigo_quality;
	}

	public Integer getDias_vacaciones() {
		return dias_vacaciones;
	}

	public void setDias_vacaciones(Integer dias_vacaciones) {
		this.dias_vacaciones = dias_vacaciones;
	}

	public Integer getDias_descanso() {
		return dias_descanso;
	}

	public void setDias_descanso(Integer dias_descanso) {
		this.dias_descanso = dias_descanso;
	}

	public Integer getIdproducto() {
		return idproducto;
	}

	public void setIdproducto(Integer idproducto) {
		this.idproducto = idproducto;
	}

	public String getProducto_principal() {
		return producto_principal;
	}

	public void setProducto_principal(String producto_principal) {
		this.producto_principal = producto_principal;
	}

	public String getOtros_productos() {
		return otros_productos;
	}

	public void setOtros_productos(String otros_productos) {
		this.otros_productos = otros_productos;
	}

	public String getNegocio_asignado() {
		return negocio_asignado;
	}

	public void setNegocio_asignado(String negocio_asignado) {
		this.negocio_asignado = negocio_asignado;
	}

	public boolean isDotacion() {
		return dotacion;
	}

	public void setDotacion(boolean dotacion) {
		this.dotacion = dotacion;
	}

	public String getDesEmpresa() {
		return desEmpresa;
	}

	public void setDesEmpresa(String desEmpresa) {
		this.desEmpresa = desEmpresa;
	}

}
