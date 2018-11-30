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
		
	@Select("SELECT id_asignacion_recurso, id_pedido, id_cortador, id_confeccionista, id_empaquetador, id_maquina_corte, id_maquina_confeccion FROM victorian.t_asignacion_recurso where id_pedido = #{id_pedido}")
	public AsignacionRecurso findByIdPedido(@Param("id_pedido") Integer id_pedido) throws Exception;
	
	@Insert("INSERT INTO victorian.t_asignacion_recurso(id_pedido, id_cortador, id_confeccionista, id_empaquetador, id_maquina_corte, id_maquina_confeccion) "
			+ "VALUES (#{id_pedido}, #{id_cortador}, #{id_confeccionista}, #{id_empaquetador}, #{id_maquina_corte}, #{id_maquina_confeccion})")
	public void insert(AsignacionRecurso asignacionRecurso) throws Exception;
	
	@Update("UPDATE victorian.t_asignacion_recurso SET id_cortador=#{id_cortador}, id_confeccionista=#{id_confeccionista}, id_empaquetador=#{id_empaquetador}, "
			+ "id_maquina_corte=#{id_maquina_corte}, id_maquina_confeccion=#{id_maquina_confeccion} where id_asignacion_recurso= #{id_asignacion_recurso}")
	@Options(flushCache=true,useCache=true)
    public void update(AsignacionRecurso asignacionRecurso) throws Exception;
	
	@Select("select * from ( "+
			"SELECT 'PERSONAL ' || top.descripcion as tipo_recurso, count(o.id_operario) AS cantidad "+ 
			"FROM victorian.t_operario o inner join victorian.t_tipooperario top on o.id_tipooperario=top.id_tipooperario " +
			"where o.activo=true and (select count(x.id_ordentrabajo) from victorian.t_ordentrabajo_operario x where x.id_operario=o.id_operario)<2 "+ 
			"group by top.descripcion "+
			"union " + 
			"SELECT 'MAQUINA ' || m.tipo as tipo_recurso, count(m.id_maquinaria) AS cantidad "+ 
			"FROM victorian.t_maquinaria m "+
			"where m.activo=true and (select count(x.id_ordentrabajo) from victorian.t_ordentrabajo_maquinaria x where x.id_maquinaria=m.id_maquinaria)<2 "+ 
			"group by tipo) as a "+ 
			"order by a.tipo_recurso")
	public List<Recurso> listarRecursosDisponibles() throws Exception;
	
}
