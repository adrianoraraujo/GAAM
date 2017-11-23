package gaamModel;

public class Integrante{

private Integer id;
private TipoIntegrante tipointegrante;
private String nome;
private String cpf;
private String endereco;
private String telefone;
private String email;
private Integer idade;
private String nome_resp;

public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public TipoIntegrante getTipointegrante() {
	return tipointegrante;
}
public void setTipointegrante(TipoIntegrante tipointegrante) {
	this.tipointegrante = tipointegrante;
}
public String getNome() {
	return nome;
}
public void setNome(String nome) {
	this.nome = nome;
}
public String getCpf() {
	return cpf;
}
public void setCpf(String cpf) {
	this.cpf = cpf;
}
public String getEndereco() {
	return endereco;
}
public void setEndereco(String endereco) {
	this.endereco = endereco;
}
public String getTelefone() {
	return telefone;
}
public void setTelefone(String telefone) {
	this.telefone = telefone;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public Integer getIdade() {
	return idade;
}
public void setIdade(Integer idade) {
	this.idade = idade;
}
public String getNome_resp() {
	return nome_resp;
}
public void setNome_resp(String nome_resp) {
	this.nome_resp = nome_resp;
}


}
