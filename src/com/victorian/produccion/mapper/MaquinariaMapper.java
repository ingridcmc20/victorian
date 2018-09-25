package com.victorian.produccion.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.victorian.produccion.domain.Maquinaria;

public interface MaquinariaMapper {
	@Select("SELECT id_maquinaria, descripcion, modelo, serie, activo, tipo FROM victorian.t_maquinaria where tipo=#{tipo}")
	public List<Maquinaria> findByEstado(@Param("tipo") String tipo) throws Exception;
	
	@Select("SELECT id_maquinaria, descripcion, modelo, serie, activo, tipo "
			+ "FROM victorian.t_maquinaria "
			+ "where tipo=#{tipo} and id_maquinaria not in ("
			+ 	"select x.id_maquinaria "
			+ "from victorian.t_ordentrabajo_maquinaria x inner join victorian.t_orden_trabajo y on y.id_ordentrabajo=x.id_ordentrabajo "
			+ "where y.id_estado not in (7, 8))")
	public List<Maquinaria> findByEstadoDisponible(@Param("tipo") String id_tipooperario) throws Exception;
	
	@Select("SELECT m.id_maquinaria, m.descripcion, m.modelo, m.serie, m.activo, m.tipo "
			+ "FROM victorian.t_maquinaria m inner join victorian.t_ordentrabajo_maquinaria oto on oto.id_maquinaria=m.id_maquinaria "
			+ "where tipo=#{tipo} and id_ordentrabajo=#{id_ordentrabajo}")
	public List<String> findByEstadoAndByIdOrden(@Param("tipo") String tipo, @Param("id_ordentrabajo") Integer id_ordentrabajo) throws Exception;
	
	@Select("SELECT id_maquinaria, descripcion, modelo, serie, activo, tipo FROM victorian.t_maquinaria where id_maquinaria=#{id_maquinaria}")
	public List<Maquinaria> findById(@Param("id_maquinaria") Integer id_maquinaria) throws Exception;
}
