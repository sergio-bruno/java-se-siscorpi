/*
 * ClasseMontaGrafico.java
 *
 * Criado em 30 de Maio de 2005, 23:30
 */
package siscorpi.gui;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.*;
// Gráfico de pizza
import org.jfree.data.general.DefaultPieDataset;
// Gráfico de barras
import org.jfree.chart.renderer.category.BarRenderer3D;
// Gráfico de barras, linha, área
import org.jfree.data.category.DefaultCategoryDataset;

//import javax.swing.*;
/**
 *
 * @author Sergio Leite Bruno
 */
public class ClasseMontaGrafico {
    /** Creates a new instance of ClaseMontaGrafico */
    public ChartPanel MontaGrafico(int wTipo, String wtituloGrafico,
    DefaultPieDataset wdataset, DefaultCategoryDataset wdatasetBar,String wtitulo1, 
    String wtitulo2) {
        JFreeChart grafico = ChartFactory.createPieChart3D(wtituloGrafico, wdataset, 
        true, false, false );
        ChartPanel painelGrafico;
        if ( wTipo == 0 ){
            grafico = ChartFactory.createPieChart3D(
            wtituloGrafico, wdataset, true, false, false );
            Plot plot = grafico.getPlot();
            plot.setForegroundAlpha(0.4F);
        }
        else if ( wTipo == 1 ) {
            grafico = ChartFactory.createBarChart3D(wtituloGrafico,
            wtitulo1,wtitulo2,wdatasetBar,PlotOrientation.VERTICAL,true,false,
            false);
            CategoryPlot plot = (CategoryPlot) grafico.getPlot();
            plot.setForegroundAlpha(0.9f);
            plot.setDomainGridlinesVisible(true);
            BarRenderer3D renderer = (BarRenderer3D) plot.getRenderer();
            renderer.setDrawBarOutline(false);
        }    
        else if ( wTipo == 2 ) {
            grafico = ChartFactory.createLineChart(wtituloGrafico,
            wtitulo1,wtitulo2,wdatasetBar,PlotOrientation.VERTICAL,true,false,
            false);
        }
        else if ( wTipo == 3 ) {
            grafico = ChartFactory.createAreaChart(wtituloGrafico,
            wtitulo1,wtitulo2,wdatasetBar,PlotOrientation.VERTICAL,true,false,
            false);
            Plot plot = grafico.getPlot();
            plot.setForegroundAlpha( 0.7f );
        }
        painelGrafico = new ChartPanel(grafico);
        //JOptionPane.showMessageDialog(null,"Montei o gráfico","Atenção",JOptionPane.WARNING_MESSAGE);	
        return painelGrafico;
    }
}
