package br.com.mundoJ.pageObject.page.mecanismoBusca;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import br.com.mundoJ.pageObject.page.PaginaBase;

public class PaginaDeResultadoDaBusca extends PaginaBase {

	private static final String LISTA_DE_RESULTADO = "div#results li cite";

	public PaginaDeResultadoDaBusca(WebDriver driver) {
		super(driver);
	}

	public boolean encontrouSite(String urlSiteProcurado) {
		List<WebElement> itensEncontrados = this
				.buscaPorElementos(LISTA_DE_RESULTADO);

		boolean elementoEncontrado = false;

		for (WebElement itemEncontrado : itensEncontrados) {
			// obtem o conteudo de um elemento cite dentro de cada item
			// encontrado
			String linkDoElementoEncontrado = itemEncontrado.getText().replaceAll(" ", "");
			elementoEncontrado = linkDoElementoEncontrado
					.contains(urlSiteProcurado);

			if (elementoEncontrado) {
				break;
			}
		}

		return elementoEncontrado;
	}

	@Override
	public String getURL() {
		throw new RuntimeException("Esta pagina nao eh acessivel por uma URL.");
	}

}
