package br.com.mundoJ.pageObject.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class PaginaBase {

	private static final long WAIT_TIME = 2000l;

	protected WebDriver driver;

	public PaginaBase(WebDriver driver) {
		this.driver = driver;
	}

	protected void preencheInputText(String cssSelector, String conteudo) {
		WebElement inputText = driver.findElement(By.cssSelector(cssSelector));
		inputText.clear();
		inputText.sendKeys(conteudo);
	}

	protected void clica(String cssSelector) {
		driver.findElement(By.cssSelector(cssSelector)).click();

		try {
			// aguarda um tempo ate a pagina do resultado de busca ser carregada
			Thread.sleep(WAIT_TIME);
		} catch (InterruptedException e) {
			throw new RuntimeException(
					"Nao foi possivel esperar a pagina ser carregada.", e);
		}
	}

	protected List<WebElement> buscaPorElementos(String cssSelector) {
		return driver.findElements(By.cssSelector(cssSelector));
	}

	protected void acessaPagina() {
		driver.navigate().to(this.getURL());
	}

	public abstract String getURL();
}
