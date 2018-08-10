package src.com.victorian.produccion.utils;

import java.util.ArrayList;
import java.util.List;

public class Criteria {
    protected List<Criterion> criteria;

    public Criteria() {
        super();
        criteria = new ArrayList<Criterion>();
    }

    public boolean isValid() {
        return criteria.size() > 0;
    }

    public List<Criterion> getAllCriteria() {
        return criteria;
    }

    public List<Criterion> getCriteria() {
        return criteria;
    }

    private void addCriterion(String condition) {
        if (condition == null) {
            throw new RuntimeException("Value for condition cannot be null");
        }
        criteria.add(new Criterion(condition));
    }

    private void addCriterion(String condition, Object value, String property) {
        if (value == null) {
            throw new RuntimeException("Value for " + property + " cannot be null");
        }
        criteria.add(new Criterion(condition, value));
    }

    private void addCriterion(String condition, Object value1, Object value2, String property) {
        if (value1 == null || value2 == null) {
            throw new RuntimeException("Between values for " + property + " cannot be null");
        }
        criteria.add(new Criterion(condition, value1, value2));
    }

    /**
     * Metodo que valida si un campo es nulo
     * @param field representa el campo que se desea validar
     * @return devuelve un nuevo criterio
     */
    public Criteria andFieldIsNull(String field) {
        addCriterion(field + " is null");
        return (Criteria) this;
    }

    /**
     * Metodo que valida si un campo no es nulo
     * @param field representa el campo que se desea validar
     * @return devuelve un nuevo criterio
     */
    public Criteria andFieldIsNotNull(String field) {
        addCriterion(field + " is not null");
        return (Criteria) this;
    }

    /**
     * Metodo que valida que un campo sea igual a un determinado valor
     * @param field representa el campo que se desea validar
     * @param value Cualquier tipo de dato que se necesita comparar
     * @return devuelve un nuevo criterio
     */
    public <T> Criteria andFieldEqualTo(String field, T value) {
        addCriterion(field + " =", value, field);
        return (Criteria) this;
    }

    /**
     * Metodo que valida que un campo sea distinto a un determinado valor
     * @param field representa el campo que se desea validar
     * @param value Cualquier tipo de dato que se necesita comparar
     * @return devuelve un nuevo criterio
     */
    public <T> Criteria andFieldNotEqualTo(String field, T value) {
        addCriterion(field + " <>", value, field);
        return (Criteria) this;
    }

    /**
     * Metodo que valida que un campo sea mayor a un determinado valor
     * @param field representa el campo que se desea validar
     * @param value Cualquier tipo de dato que se necesita comparar
     * @return devuelve un nuevo criterio
     */
    public <T> Criteria andFieldGreaterThan(String field, T value) {
        addCriterion(field + " >", value, field);
        return (Criteria) this;
    }

    /**
     * Metodo que valida que un campo sea mayor o igual a un determinado valor
     * @param field representa el campo que se desea validar
     * @param value Cualquier tipo de dato que se necesita comparar
     * @return devuelve un nuevo criterio
     */
    public <T> Criteria andFieldGreaterThanOrEqualTo(String field, T value) {
        addCriterion(field + " >=", value, field);
        return (Criteria) this;
    }

    /**
     * Metodo que valida que un campo sea menor a un determinado valor
     * @param field representa el campo que se desea validar
     * @param value Cualquier tipo de dato que se necesita comparar
     * @return devuelve un nuevo criterio
     */    
    public <T> Criteria andFieldLessThan(String field, T value) {
        addCriterion(field + " <", value, field);
        return (Criteria) this;
    }

    /**
     * Metodo que valida que un campo sea menor o igual a un determinado valor
     * @param field representa el campo que se desea validar
     * @param value Cualquier tipo de dato que se necesita comparar
     * @return devuelve un nuevo criterio
     */    
    public <T> Criteria andFieldLessThanOrEqualTo(String field, T value) {
        addCriterion(field + " <=", value, field);
        return (Criteria) this;
    }

    /**
     * Metodo que valida que un campo sea igual a algun dato dentro de una lista de valores 
     * @param field representa el campo que se desea validar
     * @param values lista de valores que recibe cualquier tipo de dato
     * @return devuelve un nuevo criterio
     */
    public Criteria andFieldIn(String field, List<?> values) {
        addCriterion(field + " in", values, field);
        return (Criteria) this;
    }

    /**
     * Metodo que valida que un campo sea distinto a algun dato dentro de una lista de valores 
     * @param field representa el campo que se desea validar
     * @param values lista de valores que recibe cualquier tipo de dato
     * @return devuelve un nuevo criterio
     */
    public Criteria andFieldNotIn(String field, List<?> values) {
        addCriterion(field + " not in", values, field);
        return (Criteria) this;
    }    

    /**
     * Metodo que valida que un campo se encuentre dentro de 2 valores determinados
     * @param field representa el campo que se desea validar
     * @param value1 valor inicial del tipo de dato a comparar
     * @param value2 valor final del tipo de dato a comparar
     * @return devuelve un nuevo criterio
     */
    public <T> Criteria andFieldBetween(String field, T value1, T value2) {
        addCriterion(field + " between", value1, value2, field);
        return (Criteria) this;
    }

    /**
     * Metodo que valida que un campo se encuentra fuera del rango de 2 valores determinados
     * @param field representa el campo que se desea validar
     * @param value1 valor inicial del tipo de dato a comparar
     * @param value2 valor final del tipo de dato a comparar
     * @return devuelve un nuevo criterio
     */
    public <T> Criteria andFieldNotBetween(String field, T value1, T value2) {
        addCriterion(field + " not between", value1, value2, field);
        return (Criteria) this;
    }
    
    /**
     * Metodo que compara un campo de texto con un campo
     * @param field representa el campo que se desea comparar
     * @param value valor del dato a comparar
     * @return devuelve un nuevo criterio
     */
    public <T> Criteria andFieldLike(String field, T value) {
        addCriterion(field + " like", value, field);
        return (Criteria) this;
    }
    
    /**
     * Metodo que compara un campo de texto con un campo
     * @param field representa el campo que se desea comparar
     * @param value valor del dato a comparar
     * @return devuelve un nuevo criterio
     */
    public <T> Criteria andFieldNotLike(String field, T value) {
        addCriterion(field + " not like", value, field);
        return (Criteria) this;
    }
}