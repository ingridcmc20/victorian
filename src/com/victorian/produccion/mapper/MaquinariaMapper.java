package com.victorian.produccion.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.victorian.produccion.domain.Maquinaria;

public interface MaquinariaMapper {
	@Select("SELECT idmaquinaria, descripcion, modelo, serie, estado, tipo FROM t_maquinaria where tipo=#{tipo}")
	public List<Maquinaria> findByEstado(@Param("tipo") String tipo) throws Exception;
	
	@Select("SELECT idmaquinaria, descripcion, modelo, serie, estado, tipo "
			+ "FROM t_maquinaria "
			+ "where tipo=#{tipo} and idmaquinaria not in ("
			+ 	"select x.id_maquinaria "
			+ "from t_orden_trabajo_maquinaria x inner join t_orden_trabajo y on y.id_orden_trabajo=x.id_orden_trabajo "
			+ "where y.id_estado not in (6))")
	public List<Maquinaria> findByEstadoDisponible(@Param("tipo") String tipo_operario) throws Exception;
	
	@Select("SELECT m.idmaquinaria, m.descripcion, m.modelo, m.serie, m.estado, m.tipo "
			+ "FROM t_maquinaria m inner join t_orden_trabajo_maquinaria oto on oto.id_maquinaria=m.idmaquinaria "
			+ "where tipo=#{tipo} and id_orden_trabajo=#{id_orden_trabajo}")
	public List<String> findByEstadoAndByIdOrden(@Param("tipo") String tipo, @Param("id_orden_trabajo") Integer id_orden_trabajo) throws Exception;
	
	@Select("SELECT idmaquinaria, descripcion, modelo, serie, estado, tipo FROM t_maquinaria where idmaquinaria=#{idmaquinaria}")
	public List<Maquinaria> findById(@Param("idmaquinaria") Integer idmaquinaria) throws Exception;
}
