package gaamModel;

public class Pagamento {

	
private Integer id;
private TipoPagamento tipo;
private Integer valor;
private Integer ano;
private Integrante integrante;
private Integer mes;
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public TipoPagamento getTipo() {
	return tipo;
}
public void setTipo(TipoPagamento tipo) {
	this.tipo = tipo;
}
public Integer getValor() {
	return valor;
}
public void setValor(Integer valor) {
	this.valor = valor;
}
public Integer getAno() {
	return ano;
}
public void setAno(Integer ano) {
	this.ano = ano;
}
public Integrante getIntegrante() {
	return integrante;
}
public void setIntegrante(Integrante integrante) {
	this.integrante = integrante;
}
public Integer getMes() {
	return mes;
}
public void setMes(Integer mes) {
	this.mes = mes;
}


}
