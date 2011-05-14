package br.com.mundoJ.pageObject.test;

import junit.framework.Assert;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import br.com.mundoJ.pageObject.page.mecanismoBusca.PaginaDeBusca;
import br.com.mundoJ.pageObject.page.mecanismoBusca.PaginaDeResultadoDaBusca;

public class TestaMecanismoBusca {

	private static WebDriver driver;

	private PaginaDeBusca paginaDeBusca;
	private PaginaDeResultadoDaBusca paginaDeResultadoDaBusca;

	@BeforeClass
	public static void preparaTestes() {
		// existem drivers especificos para os diversos browsers. Nesse caso
		// utilizaremos o firefox.
		driver = new FirefoxDriver();
	}

	@Test
	public void testaBuscaSeleniumTest() {
		dadoQueUsuarioAcessaMecanismoDeBusca();
		quandoUsuarioProcuraPor("selenium test");
		entaoMecanismoDeBuscaEncontraSite("seleniumhq.org");
	}

	@Test
	public void testaBuscaPageObjectPattern() {
		dadoQueUsuarioAcessaMecanismoDeBusca();
		quandoUsuarioProcuraPor("pageobject pattern");
		entaoMecanismoDeBuscaEncontraSite("code.google.com/p/selenium/wiki/PageObjects");
	}

	private void dadoQueUsuarioAcessaMecanismoDeBusca() {
		paginaDeBusca = PaginaDeBusca.acessa(driver);
	}

	private void quandoUsuarioProcuraPor(String conteudo) {
		paginaDeResultadoDaBusca = paginaDeBusca.realizaBusca(conteudo);
	}

	private void entaoMecanismoDeBuscaEncontraSite(String siteEsperado) {
		Assert.assertTrue(paginaDeResultadoDaBusca.encontrouSite(siteEsperado));
	}

	@AfterClass
	public static void finalizaTestes() {
		driver.close();
	}

}
