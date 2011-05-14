package br.com.mundoJ.pageObject.page.mecanismoBusca;

import org.openqa.selenium.WebDriver;

import br.com.mundoJ.pageObject.page.PaginaBase;

public class PaginaDeBusca extends PaginaBase {

	private static final String INPUT_BUSCA = "input[name=q]";
	private static final String BOTAO_DE_BUSCA = "input[name=btnG]";

	public PaginaDeBusca(WebDriver driver) {
		super(driver);
	}

	public static PaginaDeBusca acessa(WebDriver driver) {
		PaginaDeBusca paginaDeBusca = new PaginaDeBusca(driver);
		paginaDeBusca.acessaPagina();
		return paginaDeBusca;
	}

	public PaginaDeResultadoDaBusca realizaBusca(String conteudoDaBusca) {
		this.preencheInputText(INPUT_BUSCA, conteudoDaBusca);
		this.clica(BOTAO_DE_BUSCA);
		return new PaginaDeResultadoDaBusca(driver);
	}

	@Override
	public String getURL() {
		return "http://www.google.com.br";
	}

}
