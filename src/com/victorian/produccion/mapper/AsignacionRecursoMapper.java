package com.victorian.produccion.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.victorian.produccion.domain.AsignacionRecurso;
import com.victorian.produccion.domain.Recurso;

public interface AsignacionRecursoMapper {
		
	@Select("SELECT id_asignacion_recurso, id_pedido, id_cortador, id_confeccionista, id_empaquetador, id_maquina_corte, id_maquina_confeccion FROM t_asignacion_recurso where id_pedido = #{id_pedido}")
	public AsignacionRecurso findByIdPedido(@Param("id_pedido") Integer id_pedido) throws Exception;
	
	@Insert("INSERT INTO t_asignacion_recurso(id_pedido, id_cortador, id_confeccionista, id_empaquetador, id_maquina_corte, id_maquina_confeccion) "
			+ "VALUES (#{id_pedido}, #{id_cortador}, #{id_confeccionista}, #{id_empaquetador}, #{id_maquina_corte}, #{id_maquina_confeccion})")
	public void insert(AsignacionRecurso asignacionRecurso) throws Exception;
	
	@Update("UPDATE t_asignacion_recurso SET id_cortador=#{id_cortador}, id_confeccionista=#{id_confeccionista}, id_empaquetador=#{id_empaquetador}, "
			+ "id_maquina_corte=#{id_maquina_corte}, id_maquina_confeccion=#{id_maquina_confeccion} where id_asignacion_recurso= #{id_asignacion_recurso}")
	@Options(flushCache=true,useCache=true)
    public void update(AsignacionRecurso asignacionRecurso) throws Exception;
	
	@Select("select * from ( "+
			"SELECT 'PERSONAL ' || tipo_operario as tipo_recurso, COUNT(idoperario) AS cantidad FROM t_operario where estado=1 and idoperario not in "+ 
			"(select oto.id_operario from t_orden_trabajo ot inner join t_orden_trabajo_operario oto on oto.id_orden_trabajo=ot.id_orden_trabajo where id_estado<>6) "+ 
			"group by tipo_operario "+
			"union SELECT 'MAQUINA ' || tipo as tipo_recurso, count(idmaquinaria) AS cantidad "+ 
			"FROM t_maquinaria where estado='ACTIVA' AND idmaquinaria not in (select oto.id_maquinaria from t_orden_trabajo ot inner join t_orden_trabajo_maquinaria oto on oto.id_orden_trabajo=ot.id_orden_trabajo where id_estado<>6) "+ 
			"group by tipo) as a "+ 
			"order by a.tipo_recurso")
	public List<Recurso> listarRecursosDisponibles() throws Exception;
	
}
