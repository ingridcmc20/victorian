package com.victorian.produccion.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.victorian.produccion.domain.Log;

public interface LogMapper {
	
	/**
	 * @Desc: inserta un cliente, los parametros debe ser exatamente iguales en nombre que los atributos de la clase
	 * para poder pasar el objeto, de lo contrario habra que pasar parametro por parametro
	 * @param cliente: objeto cliente
	 * @return: void
	 * @throws Exception
	 */
	@Insert("insert into t_log (idusuario, cod_menu,accion,descripcion,ip_client,host_client,fecha,hora,anio) " +
			"values (#{idusuario},#{cod_menu},#{accion},#{descripcion},#{ip_client},#{host_client},now(),localtime, extract(year from now()))")
	public void insertLog(Log log) throws Exception;
	
	/**
	 * Obtener los anios que hay en la BD
	 **/
	@Select ("select distinct extract(year from fecha) from t_log")
	public List<Integer> getAniosRegistrados() throws Exception;
	
	/**
	 * Obtener el Log filtrado por mes y anio
	 * @param anio
	 * @param mes
	 **/
	@Select("SELECT a.pk_log_id,a.accion, a.descripcion, a.ip_client, a.fecha, a.hora, a.anio,a.ip_server_img, b.login , c.nombre as nombre_opMenu , d.nombre_sistema as modulo "+
			  "FROM  t_log a LEFT OUTER JOIN t_usuario b on (a.idusuario = b.idusuario) "+
			  "LEFT OUTER JOIN t_opcion_menu c on (a.cod_menu = c.cod_menu) "+
			  "LEFT OUTER JOIN t_sistema d on (c.cod_sistema = d.cod_sistema) "+
			  "WHERE extract(month from a.fecha)::int = #{p_mes}")
	public List<Log> getLogFiltradoPeriodoAnio (@Param("p_mes") Integer mes, @Param("p_anio") Integer anio) throws Exception;
	
	/*De la tabla Log*/
	
	@Select("SELECT a.pk_log_id,a.accion, a.descripcion, a.ip_client, a.fecha, a.hora, a.anio,a.ip_server_img, b.login , c.nombre as nombre_opMenu , d.nombre_sistema as modulo "
			+ " FROM  t_log a LEFT OUTER JOIN t_usuario b on (a.idusuario = b.idusuario) "
			+ " LEFT OUTER JOIN t_opcion_menu c on (a.cod_menu = c.cod_menu) "
			+ " LEFT OUTER JOIN t_sistema d on (c.cod_sistema = d.cod_sistema) WHERE a.fecha  BETWEEN #{p_fecha_inicio} and #{p_fecha_fin}")
	public List<Log> getLog_DateInterval(@Param("p_fecha_inicio") Date fecha_inicio,@Param("p_fecha_fin") Date fecha_fin) throws Exception;
	

}
