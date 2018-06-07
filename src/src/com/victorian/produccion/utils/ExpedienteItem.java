package src.com.victorian.produccion.utils;

import java.util.Date;

/**
 * Esta clase contiene campos de diversas tablas
 * se recomienda usarlo solo desde las clases mapper.java
 * se pueden añadir mas campos 
 * */

public class ExpedienteItem {
	
	private String ruc;
	private String nombre_empresa;
	private Integer nro_total_cuentas;
	private String nombrecompleto_ejecutivo;
	private String personal_contacto;
	private String estado_cita;
	private Integer citacontactoid;
	private String observacion_cita;
	
	private String tcita;
	
	private String comentario;
	private String persona_contacto;
	
	private String latitud;
	private String longitud;
	private Date fecha_cita;
	private Date fecha_cruce_gps;
	private Date estado_gps_cita;
	private Date fecha;
	private Date hora;
	
	
	private String nombre_ejecutivo;
	private String nombreverificador;
	private String numero_celular_contacto;
	private String numero_fijo_contacto;
	
	private Integer idusuario;
	private Integer cantidad;
	private Integer cantidad_mes;
	
	private Integer  empresas_asig;
	private Integer  empresas_trabajdas;
	private Integer  saldo_empresasxtrabajar;
	
	private String jefe;
	
	private Integer id_producto;
	
	
	private Integer r1_cantidad;
	private double r1_comision;
	private double r1_fact;
	
	
	private Integer r2_cantidad;
	private double r2_comision;
	private double r2_fact;
	private double r2_desembolsado;
	
	private Integer r3_cantidad;
	private double r3_comision;
	private double r3_fact;
	private double r3_desembolsado;
	
	private Integer r4_cantidad;
	private double r4_comision;
	private double r4_fact;
	private double r4_desembolsado;
	
	private Integer r5_cantidad;
	private double r5_comision;
	private double r5_fact;
	private double r5_desembolsado;
	
	private Integer r6_cantidad;
	private double r6_comision;
	private double r6_fact;
	private double r6_desembolsado;
	
	private Integer r7_cantidad;
	private double r7_comision;
	private double r7_fact;
	private double r7_desembolsado;
	
	private double desembolsado_total;
	private double monto_base;

	private double  por_rentabilidad;
	private double fact_total;
	private double comision_total;
	private Integer cantidad_total;
	
	private String tipooperacion;
	private String provincia;
	
	
	private String string_value;
	private String tipo_base;
	
	private Integer cantidad_des;
	private Integer cantidad_cont;
	
	
	private Integer cant1_ene;
	private Integer cant2_ene;
	
	private Integer cant1_feb;
	private Integer cant2_feb;
	
	private Integer cant1_mar;
	private Integer cant2_mar;
	
	private Integer cant1_abr;
	private Integer cant2_abr;
	
	private Integer cant1_may;
	private Integer cant2_may;
	
	private Integer cant1_jun;
	private Integer cant2_jun;
	
	private Integer cant1_jul;
	private Integer cant2_jul;
	
	private Integer cant1_ago;
	private Integer cant2_ago;
	
	private Integer cant1_set;
	private Integer cant2_set;
	
	private Integer cant1_oct;
	private Integer cant2_oct;
	
	private Integer cant1_nov;
	private Integer cant2_nov;
	
	private Integer cant1_dic;
	private Integer cant2_dic;
	
	private Integer cantidad1;
	
	
	private Date periodo ;
	private String mes_periodo;
	
	private String disposicion_llam;
	private String hora_rango;
	
	public String getRuc() {
		return ruc;
	}
	public void setRuc(String ruc) {
		this.ruc = ruc;
	}
	public String getNombre_empresa() {
		return nombre_empresa;
	}
	public void setNombre_empresa(String nombre_empresa) {
		this.nombre_empresa = nombre_empresa;
	}
	public Integer getNro_total_cuentas() {
		return nro_total_cuentas;
	}
	public void setNro_total_cuentas(Integer nro_total_cuentas) {
		this.nro_total_cuentas = nro_total_cuentas;
	}
	public String getNombrecompleto_ejecutivo() {
		return nombrecompleto_ejecutivo;
	}
	public void setNombrecompleto_ejecutivo(String nombrecompleto_ejecutivo) {
		this.nombrecompleto_ejecutivo = nombrecompleto_ejecutivo;
	}
	public String getPersonal_contacto() {
		return personal_contacto;
	}
	public void setPersonal_contacto(String personal_contacto) {
		this.personal_contacto = personal_contacto;
	}
	public String getEstado_cita() {
		return estado_cita;
	}
	public void setEstado_cita(String estado_cita) {
		this.estado_cita = estado_cita;
	}
	public Integer getCitacontactoid() {
		return citacontactoid;
	}
	public void setCitacontactoid(Integer citacontactoid) {
		this.citacontactoid = citacontactoid;
	}
	public String getObservacion_cita() {
		return observacion_cita;
	}
	public void setObservacion_cita(String observacion_cita) {
		this.observacion_cita = observacion_cita;
	}
	public String getLatitud() {
		return latitud;
	}
	public void setLatitud(String latitud) {
		this.latitud = latitud;
	}
	public String getLongitud() {
		return longitud;
	}
	public void setLongitud(String longitud) {
		this.longitud = longitud;
	}
	public Date getFecha_cita() {
		return fecha_cita;
	}
	public void setFecha_cita(Date fecha_cita) {
		this.fecha_cita = fecha_cita;
	}
	public Date getFecha_cruce_gps() {
		return fecha_cruce_gps;
	}
	public void setFecha_cruce_gps(Date fecha_cruce_gps) {
		this.fecha_cruce_gps = fecha_cruce_gps;
	}
	public Date getEstado_gps_cita() {
		return estado_gps_cita;
	}
	public void setEstado_gps_cita(Date estado_gps_cita) {
		this.estado_gps_cita = estado_gps_cita;
	}
	public String getNombre_ejecutivo() {
		return nombre_ejecutivo;
	}
	public void setNombre_ejecutivo(String nombre_ejecutivo) {
		this.nombre_ejecutivo = nombre_ejecutivo;
	}
	public Integer getIdusuario() {
		return idusuario;
	}
	public void setIdusuario(Integer idusuario) {
		this.idusuario = idusuario;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	public Integer getCantidad_mes() {
		return cantidad_mes;
	}
	public void setCantidad_mes(Integer cantidad_mes) {
		this.cantidad_mes = cantidad_mes;
	}
	public String getTcita() {
		return tcita;
	}
	public void setTcita(String tcita) {
		this.tcita = tcita;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	public String getPersona_contacto() {
		return persona_contacto;
	}
	public void setPersona_contacto(String persona_contacto) {
		this.persona_contacto = persona_contacto;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Date getHora() {
		return hora;
	}
	public void setHora(Date hora) {
		this.hora = hora;
	}
	public String getNombreverificador() {
		return nombreverificador;
	}
	public void setNombreverificador(String nombreverificador) {
		this.nombreverificador = nombreverificador;
	}
	public String getNumero_celular_contacto() {
		return numero_celular_contacto;
	}
	public void setNumero_celular_contacto(String numero_celular_contacto) {
		this.numero_celular_contacto = numero_celular_contacto;
	}
	public String getNumero_fijo_contacto() {
		return numero_fijo_contacto;
	}
	public void setNumero_fijo_contacto(String numero_fijo_contacto) {
		this.numero_fijo_contacto = numero_fijo_contacto;
	}
	public Integer getEmpresas_asig() {
		return empresas_asig;
	}
	public void setEmpresas_asig(Integer empresas_asig) {
		this.empresas_asig = empresas_asig;
	}
	public Integer getEmpresas_trabajdas() {
		return empresas_trabajdas;
	}
	public void setEmpresas_trabajdas(Integer empresas_trabajdas) {
		this.empresas_trabajdas = empresas_trabajdas;
	}
	public Integer getSaldo_empresasxtrabajar() {
		return saldo_empresasxtrabajar;
	}
	public void setSaldo_empresasxtrabajar(Integer saldo_empresasxtrabajar) {
		this.saldo_empresasxtrabajar = saldo_empresasxtrabajar;
	}
	public String getJefe() {
		return jefe;
	}
	public void setJefe(String jefe) {
		this.jefe = jefe;
	}
	public Integer getId_producto() {
		return id_producto;
	}
	public void setId_producto(Integer id_producto) {
		this.id_producto = id_producto;
	}
	public Integer getR1_cantidad() {
		return r1_cantidad;
	}
	public void setR1_cantidad(Integer r1_cantidad) {
		this.r1_cantidad = r1_cantidad;
	}
	public double getR1_comision() {
		return r1_comision;
	}
	public void setR1_comision(double r1_comision) {
		this.r1_comision = r1_comision;
	}
	public double getR1_fact() {
		return r1_fact;
	}
	public void setR1_fact(double r1_fact) {
		this.r1_fact = r1_fact;
	}
	public Integer getR2_cantidad() {
		return r2_cantidad;
	}
	public void setR2_cantidad(Integer r2_cantidad) {
		this.r2_cantidad = r2_cantidad;
	}
	public double getR2_comision() {
		return r2_comision;
	}
	public void setR2_comision(double r2_comision) {
		this.r2_comision = r2_comision;
	}
	public double getR2_fact() {
		return r2_fact;
	}
	public void setR2_fact(double r2_fact) {
		this.r2_fact = r2_fact;
	}
	public double getR2_desembolsado() {
		return r2_desembolsado;
	}
	public void setR2_desembolsado(double r2_desembolsado) {
		this.r2_desembolsado = r2_desembolsado;
	}
	public Integer getR3_cantidad() {
		return r3_cantidad;
	}
	public void setR3_cantidad(Integer r3_cantidad) {
		this.r3_cantidad = r3_cantidad;
	}
	public double getR3_comision() {
		return r3_comision;
	}
	public void setR3_comision(double r3_comision) {
		this.r3_comision = r3_comision;
	}
	public double getR3_fact() {
		return r3_fact;
	}
	public void setR3_fact(double r3_fact) {
		this.r3_fact = r3_fact;
	}
	public double getR3_desembolsado() {
		return r3_desembolsado;
	}
	public void setR3_desembolsado(double r3_desembolsado) {
		this.r3_desembolsado = r3_desembolsado;
	}
	public Integer getR4_cantidad() {
		return r4_cantidad;
	}
	public void setR4_cantidad(Integer r4_cantidad) {
		this.r4_cantidad = r4_cantidad;
	}
	public double getR4_comision() {
		return r4_comision;
	}
	public void setR4_comision(double r4_comision) {
		this.r4_comision = r4_comision;
	}
	public double getR4_fact() {
		return r4_fact;
	}
	public void setR4_fact(double r4_fact) {
		this.r4_fact = r4_fact;
	}
	public double getR4_desembolsado() {
		return r4_desembolsado;
	}
	public void setR4_desembolsado(double r4_desembolsado) {
		this.r4_desembolsado = r4_desembolsado;
	}
	public Integer getR5_cantidad() {
		return r5_cantidad;
	}
	public void setR5_cantidad(Integer r5_cantidad) {
		this.r5_cantidad = r5_cantidad;
	}
	public double getR5_comision() {
		return r5_comision;
	}
	public void setR5_comision(double r5_comision) {
		this.r5_comision = r5_comision;
	}
	public double getR5_fact() {
		return r5_fact;
	}
	public void setR5_fact(double r5_fact) {
		this.r5_fact = r5_fact;
	}
	public double getR5_desembolsado() {
		return r5_desembolsado;
	}
	public void setR5_desembolsado(double r5_desembolsado) {
		this.r5_desembolsado = r5_desembolsado;
	}
	public Integer getR6_cantidad() {
		return r6_cantidad;
	}
	public void setR6_cantidad(Integer r6_cantidad) {
		this.r6_cantidad = r6_cantidad;
	}
	public double getR6_comision() {
		return r6_comision;
	}
	public void setR6_comision(double r6_comision) {
		this.r6_comision = r6_comision;
	}
	public double getR6_fact() {
		return r6_fact;
	}
	public void setR6_fact(double r6_fact) {
		this.r6_fact = r6_fact;
	}
	public double getR6_desembolsado() {
		return r6_desembolsado;
	}
	public void setR6_desembolsado(double r6_desembolsado) {
		this.r6_desembolsado = r6_desembolsado;
	}
	public Integer getR7_cantidad() {
		return r7_cantidad;
	}
	public void setR7_cantidad(Integer r7_cantidad) {
		this.r7_cantidad = r7_cantidad;
	}
	public double getR7_comision() {
		return r7_comision;
	}
	public void setR7_comision(double r7_comision) {
		this.r7_comision = r7_comision;
	}
	public double getR7_fact() {
		return r7_fact;
	}
	public void setR7_fact(double r7_fact) {
		this.r7_fact = r7_fact;
	}
	public double getR7_desembolsado() {
		return r7_desembolsado;
	}
	public void setR7_desembolsado(double r7_desembolsado) {
		this.r7_desembolsado = r7_desembolsado;
	}
	public double getDesembolsado_total() {
		return desembolsado_total;
	}
	public void setDesembolsado_total(double desembolsado_total) {
		this.desembolsado_total = desembolsado_total;
	}
	public double getMonto_base() {
		return monto_base;
	}
	public void setMonto_base(double monto_base) {
		this.monto_base = monto_base;
	}
	public double getPor_rentabilidad() {
		return por_rentabilidad;
	}
	public void setPor_rentabilidad(double por_rentabilidad) {
		this.por_rentabilidad = por_rentabilidad;
	}
	public double getFact_total() {
		return fact_total;
	}
	public void setFact_total(double fact_total) {
		this.fact_total = fact_total;
	}
	public double getComision_total() {
		return comision_total;
	}
	public void setComision_total(double comision_total) {
		this.comision_total = comision_total;
	}
	public Integer getCantidad_total() {
		return cantidad_total;
	}
	public void setCantidad_total(Integer cantidad_total) {
		this.cantidad_total = cantidad_total;
	}
	public String getTipooperacion() {
		return tipooperacion;
	}
	public void setTipooperacion(String tipooperacion) {
		this.tipooperacion = tipooperacion;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public String getString_value() {
		return string_value;
	}
	public void setString_value(String string_value) {
		this.string_value = string_value;
	}
	public String getTipo_base() {
		return tipo_base;
	}
	public void setTipo_base(String tipo_base) {
		this.tipo_base = tipo_base;
	}
	public Integer getCantidad_des() {
		return cantidad_des;
	}
	public void setCantidad_des(Integer cantidad_des) {
		this.cantidad_des = cantidad_des;
	}
	public Integer getCantidad_cont() {
		return cantidad_cont;
	}
	public void setCantidad_cont(Integer cantidad_cont) {
		this.cantidad_cont = cantidad_cont;
	}
	public Integer getCant1_ene() {
		return cant1_ene;
	}
	public void setCant1_ene(Integer cant1_ene) {
		this.cant1_ene = cant1_ene;
	}
	public Integer getCant2_ene() {
		return cant2_ene;
	}
	public void setCant2_ene(Integer cant2_ene) {
		this.cant2_ene = cant2_ene;
	}
	public Integer getCant1_feb() {
		return cant1_feb;
	}
	public void setCant1_feb(Integer cant1_feb) {
		this.cant1_feb = cant1_feb;
	}
	public Integer getCant2_feb() {
		return cant2_feb;
	}
	public void setCant2_feb(Integer cant2_feb) {
		this.cant2_feb = cant2_feb;
	}
	public Integer getCant1_mar() {
		return cant1_mar;
	}
	public void setCant1_mar(Integer cant1_mar) {
		this.cant1_mar = cant1_mar;
	}
	public Integer getCant2_mar() {
		return cant2_mar;
	}
	public void setCant2_mar(Integer cant2_mar) {
		this.cant2_mar = cant2_mar;
	}
	public Integer getCant1_abr() {
		return cant1_abr;
	}
	public void setCant1_abr(Integer cant1_abr) {
		this.cant1_abr = cant1_abr;
	}
	public Integer getCant2_abr() {
		return cant2_abr;
	}
	public void setCant2_abr(Integer cant2_abr) {
		this.cant2_abr = cant2_abr;
	}
	public Integer getCant1_may() {
		return cant1_may;
	}
	public void setCant1_may(Integer cant1_may) {
		this.cant1_may = cant1_may;
	}
	public Integer getCant2_may() {
		return cant2_may;
	}
	public void setCant2_may(Integer cant2_may) {
		this.cant2_may = cant2_may;
	}
	public Integer getCant1_jun() {
		return cant1_jun;
	}
	public void setCant1_jun(Integer cant1_jun) {
		this.cant1_jun = cant1_jun;
	}
	public Integer getCant2_jun() {
		return cant2_jun;
	}
	public void setCant2_jun(Integer cant2_jun) {
		this.cant2_jun = cant2_jun;
	}
	public Integer getCant1_jul() {
		return cant1_jul;
	}
	public void setCant1_jul(Integer cant1_jul) {
		this.cant1_jul = cant1_jul;
	}
	public Integer getCant2_jul() {
		return cant2_jul;
	}
	public void setCant2_jul(Integer cant2_jul) {
		this.cant2_jul = cant2_jul;
	}
	public Integer getCant1_ago() {
		return cant1_ago;
	}
	public void setCant1_ago(Integer cant1_ago) {
		this.cant1_ago = cant1_ago;
	}
	public Integer getCant2_ago() {
		return cant2_ago;
	}
	public void setCant2_ago(Integer cant2_ago) {
		this.cant2_ago = cant2_ago;
	}
	public Integer getCant1_set() {
		return cant1_set;
	}
	public void setCant1_set(Integer cant1_set) {
		this.cant1_set = cant1_set;
	}
	public Integer getCant2_set() {
		return cant2_set;
	}
	public void setCant2_set(Integer cant2_set) {
		this.cant2_set = cant2_set;
	}
	public Integer getCant1_oct() {
		return cant1_oct;
	}
	public void setCant1_oct(Integer cant1_oct) {
		this.cant1_oct = cant1_oct;
	}
	public Integer getCant2_oct() {
		return cant2_oct;
	}
	public void setCant2_oct(Integer cant2_oct) {
		this.cant2_oct = cant2_oct;
	}
	public Integer getCant1_nov() {
		return cant1_nov;
	}
	public void setCant1_nov(Integer cant1_nov) {
		this.cant1_nov = cant1_nov;
	}
	public Integer getCant2_nov() {
		return cant2_nov;
	}
	public void setCant2_nov(Integer cant2_nov) {
		this.cant2_nov = cant2_nov;
	}
	public Integer getCant1_dic() {
		return cant1_dic;
	}
	public void setCant1_dic(Integer cant1_dic) {
		this.cant1_dic = cant1_dic;
	}
	public Integer getCant2_dic() {
		return cant2_dic;
	}
	public void setCant2_dic(Integer cant2_dic) {
		this.cant2_dic = cant2_dic;
	}
	public Integer getCantidad1() {
		return cantidad1;
	}
	public void setCantidad1(Integer cantidad1) {
		this.cantidad1 = cantidad1;
	}
	public Date getPeriodo() {
		return periodo;
	}
	public void setPeriodo(Date periodo) {
		this.periodo = periodo;
	}
	public String getMes_periodo() {
		return mes_periodo;
	}
	public void setMes_periodo(String mes_periodo) {
		this.mes_periodo = mes_periodo;
	}
	public String getDisposicion_llam() {
		return disposicion_llam;
	}
	public void setDisposicion_llam(String disposicion_llam) {
		this.disposicion_llam = disposicion_llam;
	}
	public String getHora_rango() {
		return hora_rango;
	}
	public void setHora_rango(String hora_rango) {
		this.hora_rango = hora_rango;
	}
	
	
	
	
}
