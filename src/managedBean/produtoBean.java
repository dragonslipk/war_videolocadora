package managedBean;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import EJB.RegisterProduto;
import model.Produto;

@ManagedBean
@SessionScoped
public class produtoBean {
	
	@EJB	
	private RegisterProduto cadProd;

	private Produto selectedProduto;

	private String find;
	
	public String getFind() {
		return find;
	}

	public void setFind(String find) {
		this.find = find;
	}

	public List<Produto> getProdutoList(){
		return cadProd.listProdutos();
	}
	
	public String generateSampleProduto(){
		cadProd.createSampleProduto();
		return null;	
	}
	
	public Produto getSelectedProduto(){
		return selectedProduto;
	}
	
	public void setSelectedProduto(Produto selectedProduto){
		this.selectedProduto = selectedProduto;
	}
	
	public String update(){
		
		cadProd.findOrUpdate(selectedProduto);
		
		return "sampleCustomer";
		
	}

}
