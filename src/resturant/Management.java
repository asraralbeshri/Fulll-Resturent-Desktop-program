package resturant;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.List;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.io.FileOutputStream;
import java.sql.*;
import java.text.MessageFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import java.text.*;
import java.awt.print.*;
import java.io.File;
import java.io.OutputStream;
import java.util.Vector;
import javax.print.PrintException;
import org.jfree.chart.ChartRenderingInfo;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.entity.StandardEntityCollection;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.jdbc.JDBCCategoryDataset;

/**
 *
 * @author AsrarMeshal
 */
public class Management extends javax.swing.JFrame {

    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    // String typ1 , type2;

    double total_1, total_2, total_3, total_4, total_5, total_6, total_7, total_8, total_9, total_10, total_11, total_12;
    double sum_hms, sum_waragenab, sum_babagnooj, sum_labnahthoom, sum_shorbahdajajkudar, sum_shorbahmashroom, sum_shorbahkudar; //sum_wragenab;
    double sum_makaronahSaladM, sum_makaronah, sum_dajajSalad, sum_dajajMargoog, sum_dajajMajboos, sum_dajajMarag, sum_majboosLaham, sum_bryaniLaham, sum_maragLaham;
    double sum_whiteRice, sum_sheriaRice, sum_adasRice;
    double sum_fatoosh, sum_malfoofSalad, sum_tabolah, sum_greenSalad, sum_tunaSalad, sum_PotatosSalad, sum_ceserSalad, sum_makaronahsSalad;
    double sum_water, sum_tea, sum_turkishcoffee, sum_coffee;
    double sum_appleJuice, sum_orangeJuice, sum_pineappleJuice, sum_redGrabesJuice, sum_pomegranateJuice;
    double total_day, total_month, total_year;

    public Management() {
        initComponents();
        currentDate();
        con = Connect.connect();
        update_table();
        fillList();
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.LIGHT_GRAY);
        jTabbedPane1.setSize(900, 757);
        jTabbedPane1.setSelectedIndex(0);
        panel_search.setVisible(false);
        jPanel_time.setVisible(false);

    }

    private void select_month_total(String year) {
        try {
            String sql = "select sum(total) from invoices where month = 'January' and year = '" + year + "' ";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            String s = rs.getString("sum(total)");
            total_1 = Double.parseDouble(s);
            pst.close();
            rs.close();
        } catch (Exception e) {
           // JOptionPane.showMessageDialog(null, e);
        } finally {
            try {
                pst.close();
                rs.close();
            } catch (SQLException ex) {
               // Logger.getLogger(Management.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        try {
            String sql = "select sum(total) from invoices where month = 'Febraury' and year = '" + year + "' ";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            String s = rs.getString("sum(total)");
            total_2 = Double.parseDouble(s);
            pst.close();
            rs.close();
        } catch (Exception e) {
           // JOptionPane.showMessageDialog(null, e);
        } finally {
            try {
                pst.close();
                rs.close();
            } catch (SQLException ex) {
               // Logger.getLogger(Management.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        try {
            String sql = "select sum(total) from invoices where month = 'March' and year = '" + year + "' ";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            String s = rs.getString("sum(total)");
            total_3 = Double.parseDouble(s);
            pst.close();
            rs.close();
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, e);
        } finally {
            try {
                pst.close();
                rs.close();
            } catch (SQLException ex) {
               // Logger.getLogger(Management.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        try {
            String sql = "select sum(total) from invoices where month = 'April' and year = '" + year + "' ";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            String s = rs.getString("sum(total)");
            total_4 = Double.parseDouble(s);
            pst.close();
            rs.close();
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, e);
        } finally {
            try {
                pst.close();
                rs.close();
            } catch (SQLException ex) {
               // Logger.getLogger(Management.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        try {
            String sql = "select sum(total) from invoices where month = 'May' and year = '" + year + "' ";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            String s = rs.getString("sum(total)");
            total_5 = Double.parseDouble(s);
            pst.close();
            rs.close();
        } catch (Exception e) {
           // JOptionPane.showMessageDialog(null, e);
        } finally {
            try {
                pst.close();
                rs.close();
            } catch (SQLException ex) {
               // Logger.getLogger(Management.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        try {
            String sql = "select sum(total) from invoices where month = 'June' and year = '" + year + "' ";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            String s = rs.getString("sum(total)");
            total_6 = Double.parseDouble(s);
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, e);
        } finally {
            try {
                pst.close();
                rs.close();
            } catch (SQLException ex) {
               // Logger.getLogger(Management.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        try {
            String sql = "select sum(total) from invoices where month = 'July' and year = '" + year + "' ";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            String s = rs.getString("sum(total)");
            total_7 = Double.parseDouble(s);
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, e);
        } finally {
            try {
                pst.close();
                rs.close();
            } catch (SQLException ex) {
              //  Logger.getLogger(Management.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        try {
            String sql = "select sum(total) from invoices where month = 'August' and year = '" + year + "' ";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            String s = rs.getString("sum(total)");
            total_8 = Double.parseDouble(s);
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, e);
        } finally {
            try {
                pst.close();
                rs.close();
            } catch (SQLException ex) {
             //   Logger.getLogger(Management.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        try {
            String sql = "select sum(total) from invoices where month = 'September' and year = '" + year + "' ";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            String s = rs.getString("sum(total)");
            total_9 = Double.parseDouble(s);
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, e);
        } finally {
            try {
                pst.close();
                rs.close();
            } catch (SQLException ex) {
               // Logger.getLogger(Management.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        try {
            String sql = "select sum(total) from invoices where month = 'October' and year = '" + year + "' ";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            String s = rs.getString("sum(total)");
            total_10 = Double.parseDouble(s);
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, e);
        } finally {
            try {
                pst.close();
                rs.close();
            } catch (SQLException ex) {
              //  Logger.getLogger(Management.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        try {
            String sql = "select sum(total) from invoices where month = 'November' and year = '" + year + "' ";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            String s = rs.getString("sum(total)");
            total_11 = Double.parseDouble(s);
        } catch (Exception e) {
           // JOptionPane.showMessageDialog(null, e);
        } finally {
            try {
                pst.close();
                rs.close();
            } catch (SQLException ex) {
               // Logger.getLogger(Management.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        try {
            String sql = "select sum(total) from invoices where month = 'December' and year = '" + year + "' ";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            String s = rs.getString("sum(total)");
            total_12 = Double.parseDouble(s);
        } catch (Exception e) {
          //  JOptionPane.showMessageDialog(null, e);
        }
    }

    private double select_day_total(String date) {
        try {
            String sql = "select sum(total) from invoices where date = '" + date + "' ";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            if (rs.next()) {
                String r = rs.getString("sum(total)");
                total_day = Double.parseDouble(r);
            }

        } catch (Exception e) {
           // JOptionPane.showMessageDialog(null, e);
        } finally {
            try {
                pst.close();
                rs.close();
            } catch (SQLException ex) {
               // Logger.getLogger(Management.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return total_day;
    }

    private double select_month_total(String month, String year_month) {
        try {
            String sql = "select sum(total) from invoices where month = '" + month + "' and year = '" + year_month + "' ";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            if (rs.next()) {
                String r = rs.getString("sum(total)");
                total_month = Double.parseDouble(r);
            }
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, e);
        } finally {
            try {
                pst.close();
                rs.close();
            } catch (SQLException ex) {
               // Logger.getLogger(Management.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return total_month;
    }

    private double select_year_total(String year) {
        try {
            String sql = "select sum(total) from invoices where year = '" + year + "' ";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            if (rs.next()) {
                String r = rs.getString("sum(total)");
                total_year = Double.parseDouble(r);
            }
        } catch (Exception e) {
           // JOptionPane.showMessageDialog(null, e);
        } finally {
            try {
                pst.close();
                rs.close();
            } catch (SQLException ex) {
               // Logger.getLogger(Management.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return total_year;
    }

    private void select_type1(String date, String month, String year_month, String year) {
        if (search_day1.isSelected()) {
            // حمص
            try {
                //System.out.print("hi");
                String sql = "select sum(quantity) from foodInfo where foodType = 'حمص' and date = '" + date + "' ";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                String s = rs.getString("sum(quantity)");
                sum_hms = Double.parseDouble(s);

            } catch (Exception e) {
              //  JOptionPane.showMessageDialog(null, e);
            } finally {
                try {
                    pst.close();
                    rs.close();
                } catch (SQLException ex) {
                  //  Logger.getLogger(Management.class.getName()).log(Level.SEVERE, null, ex);
                }

                // بابا غنوج
            }
            try {
                //System.out.print("hi");
                String sql = "select sum(quantity) from foodInfo where foodType ='باباغنوج' and date = '" + date + "' ";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                String s = rs.getString("sum(quantity)");
                sum_babagnooj = Double.parseDouble(s);

            } catch (Exception e) {
                //JOptionPane.showMessageDialog(null, e);
            } finally {
                try {
                    pst.close();
                    rs.close();
                } catch (SQLException ex) {
                  //  Logger.getLogger(Management.class.getName()).log(Level.SEVERE, null, ex);
                }
                // ورق عنب 
            }
            try {
                //System.out.print("hi");
                String sql = "select sum(quantity) from foodInfo where foodType = 'ورق عنب ' and date = '" + date + "' ";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                String s = rs.getString("sum(quantity)");
                sum_waragenab = Double.parseDouble(s);

            } catch (Exception e) {
                //JOptionPane.showMessageDialog(null, e);
            } finally {
                try {
                    pst.close();
                    rs.close();
                } catch (SQLException ex) {
                  //  Logger.getLogger(Management.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            // لبنة بالثوم
            try {
                //System.out.print("hi");
                String sql = "select sum(quantity) from foodInfo where foodType = 'لبنة بالثوم' and date = '" + date + "' ";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                String s = rs.getString("sum(quantity)");
                sum_labnahthoom = Double.parseDouble(s);

            } catch (Exception e) {
               // JOptionPane.showMessageDialog(null, e);
            } finally {
                try {
                    pst.close();
                    rs.close();
                } catch (SQLException ex) {
                   // Logger.getLogger(Management.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        } else if (search_month1.isSelected()) {
            // حمص
            try {
                //System.out.print("hi");
                String sql = "select sum(quantity) from foodInfo where foodType = 'حمص' and month = '" + month + "' and year = '" + year_month + "' ";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                String s = rs.getString("sum(quantity)");
                sum_hms = Double.parseDouble(s);

            } catch (Exception e) {
               // JOptionPane.showMessageDialog(null, e);
            } finally {
                try {
                    pst.close();
                    rs.close();
                } catch (SQLException ex) {
                  //  Logger.getLogger(Management.class.getName()).log(Level.SEVERE, null, ex);
                }

                // بابا غنوج
            }
            try {
                //System.out.print("hi");
                String sql = "select sum(quantity) from foodInfo where foodType ='باباغنوج' and month = '" + month + "' and year = '" + year_month + "' ";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                String s = rs.getString("sum(quantity)");
                sum_babagnooj = Double.parseDouble(s);

            } catch (Exception e) {
              //  JOptionPane.showMessageDialog(null, e);
            } finally {
                try {
                    pst.close();
                    rs.close();
                } catch (SQLException ex) {
                   // Logger.getLogger(Management.class.getName()).log(Level.SEVERE, null, ex);
                }
                // ورق عنب 
            }
            try {
                //System.out.print("hi");
                String sql = "select sum(quantity) from foodInfo where foodType = 'ورق عنب ' and month = '" + month + "' and year = '" + year_month + "' ";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                String s = rs.getString("sum(quantity)");
                sum_waragenab = Double.parseDouble(s);

            } catch (Exception e) {
                //JOptionPane.showMessageDialog(null, e);
            } finally {
                try {
                    pst.close();
                    rs.close();
                } catch (SQLException ex) {
                  //  Logger.getLogger(Management.class.getName()).log(Level.SEVERE, null, ex);
                }
                // لبنة بالثوم
            }
            try {
                //System.out.print("hi");
                String sql = "select sum(quantity) from foodInfo where foodType = 'لبنة بالثوم' and month = '" + month + "' and year = '" + year_month + "' ";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                String s = rs.getString("sum(quantity)");
                sum_labnahthoom = Double.parseDouble(s);

            } catch (Exception e) {
               // JOptionPane.showMessageDialog(null, e);
            } finally {
                try {
                    pst.close();
                    rs.close();
                } catch (SQLException ex) {
                  //  Logger.getLogger(Management.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        } else if (search_year1.isSelected()) {
            // حمص
            try {
                //System.out.print("hi");
                String sql = "select sum(quantity) from foodInfo where foodType = 'حمص' and year = '" + year + "' ";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                String s = rs.getString("sum(quantity)");
                sum_hms = Double.parseDouble(s);

            } catch (Exception e) {
              //  JOptionPane.showMessageDialog(null, e);
            } finally {
                try {
                    pst.close();
                    rs.close();
                } catch (SQLException ex) {
                  //  Logger.getLogger(Management.class.getName()).log(Level.SEVERE, null, ex);
                }

                // بابا غنوج
            }
            try {
                //System.out.print("hi");
                String sql = "select sum(quantity) from foodInfo where foodType ='باباغنوج' and year = '" + year + "' ";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                String s = rs.getString("sum(quantity)");
                sum_babagnooj = Double.parseDouble(s);

            } catch (Exception e) {
               // JOptionPane.showMessageDialog(null, e);
            } finally {
                try {
                    pst.close();
                    rs.close();
                } catch (SQLException ex) {
                 //   Logger.getLogger(Management.class.getName()).log(Level.SEVERE, null, ex);
                }
                // ورق عنب 
            }
            try {
                //System.out.print("hi");
                String sql = "select sum(quantity) from foodInfo where foodType = 'ورق عنب ' and year = '" + year + "' ";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                String s = rs.getString("sum(quantity)");
                sum_waragenab = Double.parseDouble(s);

            } catch (Exception e) {
               // JOptionPane.showMessageDialog(null, e);
            } finally {
                try {
                    pst.close();
                    rs.close();
                } catch (SQLException ex) {
                  //  Logger.getLogger(Management.class.getName()).log(Level.SEVERE, null, ex);
                }
                // لبنة بالثوم
            }
            try {
                //System.out.print("hi");
                String sql = "select sum(quantity) from foodInfo where foodType = 'لبنة بالثوم' and year = '" + year + "' ";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                String s = rs.getString("sum(quantity)");
                sum_labnahthoom = Double.parseDouble(s);

            } catch (Exception e) {
               // JOptionPane.showMessageDialog(null, e);
            } finally {
                try {
                    pst.close();
                    rs.close();
                } catch (SQLException ex) {
                  //  Logger.getLogger(Management.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        }
    }

    private void select_type2(String date, String month, String year_month, String year) {

        if (search_day1.isSelected()) {
            try {
                //شوربة دجاج بالخضار
                String sql = "select sum(quantity) from foodInfo where foodType = 'شوربة دجاج بالخضار' and date = '" + date + "' ";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                String s = rs.getString("sum(quantity)");
                sum_shorbahdajajkudar = Double.parseDouble(s);

            } catch (Exception e) {
               // JOptionPane.showMessageDialog(null, e);
            } finally {
                try {
                    pst.close();
                    rs.close();
                } catch (SQLException ex) {
                  //  Logger.getLogger(Management.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

            try {
                //شوربة مشروم
                String sql = "select sum(quantity) from foodInfo where foodType = 'شوربة مشروم' and date = '" + date + "' ";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                String s = rs.getString("sum(quantity)");
                sum_shorbahmashroom = Double.parseDouble(s);

            } catch (Exception e) {
               // JOptionPane.showMessageDialog(null, e);
            } finally {
                try {
                    pst.close();
                    rs.close();
                } catch (SQLException ex) {
                   // Logger.getLogger(Management.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            try {
                //شوربة خضار
                String sql = "select sum(quantity) from foodInfo where foodType = 'شوربة خضار' and date = '" + date + "' ";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                String s = rs.getString("sum(quantity)");
                sum_shorbahkudar = Double.parseDouble(s);

            } catch (Exception e) {
               // JOptionPane.showMessageDialog(null, e);
            } finally {
                try {
                    pst.close();
                    rs.close();
                } catch (SQLException ex) {
                   // Logger.getLogger(Management.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        } else if (search_month2.isSelected()) {
            try {
                //شوربة دجاج بالخضار
                String sql = "select sum(quantity) from foodInfo where foodType = 'شوربة دجاج بالخضار' and month = '" + month + "' and year = '" + year_month + "' ";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                String s = rs.getString("sum(quantity)");
                sum_shorbahdajajkudar = Double.parseDouble(s);

            } catch (Exception e) {
             //   JOptionPane.showMessageDialog(null, e);
            } finally {
                try {
                    pst.close();
                    rs.close();
                } catch (SQLException ex) {
                    //Logger.getLogger(Management.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

            try {
                //شوربة مشروم
                String sql = "select sum(quantity) from foodInfo where foodType = 'شوربة مشروم' and month = '" + month + "' and year = '" + year_month + "' ";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                String s = rs.getString("sum(quantity)");
                sum_shorbahmashroom = Double.parseDouble(s);

            } catch (Exception e) {
              //  JOptionPane.showMessageDialog(null, e);
            } finally {
                try {
                    pst.close();
                    rs.close();
                } catch (SQLException ex) {
                   // Logger.getLogger(Management.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            try {
                //شوربة خضار
                String sql = "select sum(quantity) from foodInfo where foodType = 'شوربة خضار' and month = '" + month + "' and year = '" + year_month + "' ";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                String s = rs.getString("sum(quantity)");
                sum_shorbahkudar = Double.parseDouble(s);

            } catch (Exception e) {
              //  JOptionPane.showMessageDialog(null, e);
            } finally {
                try {
                    pst.close();
                    rs.close();
                } catch (SQLException ex) {
                 //   Logger.getLogger(Management.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        } else if (search_year1.isSelected()) {
            try {
                //شوربة دجاج بالخضار
                String sql = "select sum(quantity) from foodInfo where foodType = 'شوربة دجاج بالخضار' and year = '" + year + "' ";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                String s = rs.getString("sum(quantity)");
                sum_shorbahdajajkudar = Double.parseDouble(s);

            } catch (Exception e) {
               // JOptionPane.showMessageDialog(null, e);
            } finally {
                try {
                    pst.close();
                    rs.close();
                } catch (SQLException ex) {
                  //  Logger.getLogger(Management.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

            try {
                //شوربة مشروم
                String sql = "select sum(quantity) from foodInfo where foodType = 'شوربة مشروم' and year = '" + year + "' ";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                String s = rs.getString("sum(quantity)");
                sum_shorbahmashroom = Double.parseDouble(s);

            } catch (Exception e) {
               // JOptionPane.showMessageDialog(null, e);
            } finally {
                try {
                    pst.close();
                    rs.close();
                } catch (SQLException ex) {
                  //  Logger.getLogger(Management.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            try {
                //شوربة خضار
                String sql = "select sum(quantity) from foodInfo where foodType = 'شوربة خضار' and year = '" + year + "' ";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                String s = rs.getString("sum(quantity)");
                sum_shorbahkudar = Double.parseDouble(s);

            } catch (Exception e) {
              //  JOptionPane.showMessageDialog(null, e);
            } finally {
                try {
                    pst.close();
                    rs.close();
                } catch (SQLException ex) {
                  //  Logger.getLogger(Management.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        }

    }

    private void select_type3(String date, String month, String year_month, String year) {

        if (search_day1.isSelected()) {
            try {
                //سلطة المعكرونة المشكلة
                String sql = "select sum(quantity) from foodInfo where foodType = 'سلطة المعكرونة المشكلة ' and date = '" + date + "' ";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                String s = rs.getString("sum(quantity)");
                sum_makaronahSaladM = Double.parseDouble(s);

            } catch (Exception e) {
               // JOptionPane.showMessageDialog(null, e);
            } finally {
                try {
                    pst.close();
                    rs.close();
                } catch (SQLException ex) {
                  //  Logger.getLogger(Management.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            try {
                //معكرونة سادة
                String sql = "select sum(quantity) from foodInfo where foodType = 'معكرونة سادة ' and date = '" + date + "' ";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                String s = rs.getString("sum(quantity)");
                sum_makaronah = Double.parseDouble(s);

            } catch (Exception e) {
               // JOptionPane.showMessageDialog(null, e);
            } finally {
                try {
                    pst.close();
                    rs.close();
                } catch (SQLException ex) {
                  //  Logger.getLogger(Management.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        } else if (search_month1.isSelected()) {
            try {
                //سلطة المعكرونة المشكلة
                String sql = "select sum(quantity) from foodInfo where foodType = 'سلطة المعكرونة المشكلة ' and month = '" + month + "' and year = '" + year_month + "' ";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                String s = rs.getString("sum(quantity)");
                sum_makaronahSaladM = Double.parseDouble(s);

            } catch (Exception e) {
               // JOptionPane.showMessageDialog(null, e);
            } finally {
                try {
                    pst.close();
                    rs.close();
                } catch (SQLException ex) {
                  //  Logger.getLogger(Management.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            try {
                //معكرونة سادة
                String sql = "select sum(quantity) from foodInfo where foodType = 'معكرونة سادة ' and month = '" + month + "' and year = '" + year_month + "' ";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                String s = rs.getString("sum(quantity)");
                sum_makaronah = Double.parseDouble(s);

            } catch (Exception e) {
                //JOptionPane.showMessageDialog(null, e);
            } finally {
                try {
                    pst.close();
                    rs.close();
                } catch (SQLException ex) {
                   // Logger.getLogger(Management.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        } else if (search_year1.isSelected()) {
            try {
                //سلطة المعكرونة المشكلة
                String sql = "select sum(quantity) from foodInfo where foodType = 'سلطة المعكرونة المشكلة ' and year = '" + year + "' ";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                String s = rs.getString("sum(quantity)");
                sum_makaronahSaladM = Double.parseDouble(s);

            } catch (Exception e) {
               // JOptionPane.showMessageDialog(null, e);
            } finally {
                try {
                    pst.close();
                    rs.close();
                } catch (SQLException ex) {
                  //  Logger.getLogger(Management.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            try {
                //معكرونة سادة
                String sql = "select sum(quantity) from foodInfo where foodType = 'معكرونة سادة ' and year = '" + year + "' ";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                String s = rs.getString("sum(quantity)");
                sum_makaronah = Double.parseDouble(s);

            } catch (Exception e) {
               // JOptionPane.showMessageDialog(null, e);
            } finally {
                try {
                    pst.close();
                    rs.close();
                } catch (SQLException ex) {
                  //  Logger.getLogger(Management.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        }

    }

    private void select_type4(String date, String month, String year_month, String year) {
        if (search_day1.isSelected()) {
            try {
                //سلطة الدجاج المشوي
                String sql = "select sum(quantity) from foodInfo where foodType = 'سلطة الدجاج المشوي' and date = '" + date + "' ";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                String s = rs.getString("sum(quantity)");
                sum_dajajSalad = Double.parseDouble(s);

            } catch (Exception e) {
                //JOptionPane.showMessageDialog(null, e);
            } finally {
                try {
                    pst.close();
                    rs.close();
                } catch (SQLException ex) {
                   // Logger.getLogger(Management.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            try {
                //مرقوق دجاج
                String sql = "select sum(quantity) from foodInfo where foodType = 'مرقوق دجاج ' and date = '" + date + "' ";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                String s = rs.getString("sum(quantity)");
                sum_dajajMargoog = Double.parseDouble(s);

            } catch (Exception e) {
               // JOptionPane.showMessageDialog(null, e);
            } finally {
                try {
                    pst.close();
                    rs.close();
                } catch (SQLException ex) {
                  //  Logger.getLogger(Management.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            try {
                //مجبوس دجاج
                String sql = "select sum(quantity) from foodInfo where foodType = 'مجبوس دجاج' and date = '" + date + "' ";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                String s = rs.getString("sum(quantity)");
                sum_dajajMajboos = Double.parseDouble(s);

            } catch (Exception e) {
                //JOptionPane.showMessageDialog(null, e);
            } finally {
                try {
                    pst.close();
                    rs.close();
                } catch (SQLException ex) {
                   // Logger.getLogger(Management.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            try {
                //مرق دجاج
                String sql = "select sum(quantity) from foodInfo where foodType = 'مرق دجاج  ' and date = '" + date + "' ";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                String s = rs.getString("sum(quantity)");
                sum_dajajMarag = Double.parseDouble(s);

            } catch (Exception e) {
               // JOptionPane.showMessageDialog(null, e);
            } finally {
                try {
                    pst.close();
                    rs.close();
                } catch (SQLException ex) {
                   // Logger.getLogger(Management.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        } else if (search_month1.isSelected()) {
            try {
                //سلطة الدجاج المشوي
                String sql = "select sum(quantity) from foodInfo where foodType = 'سلطة الدجاج المشوي' and month = '" + month + "' and year = '" + year_month + "' ";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                String s = rs.getString("sum(quantity)");
                sum_dajajSalad = Double.parseDouble(s);

            } catch (Exception e) {
               // JOptionPane.showMessageDialog(null, e);
            } finally {
                try {
                    pst.close();
                    rs.close();
                } catch (SQLException ex) {
                   // Logger.getLogger(Management.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            try {
                //مرقوق دجاج
                String sql = "select sum(quantity) from foodInfo where foodType = 'مرقوق دجاج ' and month = '" + month + "' and year = '" + year_month + "' ";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                String s = rs.getString("sum(quantity)");
                sum_dajajMargoog = Double.parseDouble(s);

            } catch (Exception e) {
               // JOptionPane.showMessageDialog(null, e);
            } finally {
                try {
                    pst.close();
                    rs.close();
                } catch (SQLException ex) {
                   // Logger.getLogger(Management.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            try {
                //مجبوس دجاج
                String sql = "select sum(quantity) from foodInfo where foodType = 'مجبوس دجاج' and month = '" + month + "' and year = '" + year_month + "' ";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                String s = rs.getString("sum(quantity)");
                sum_dajajMajboos = Double.parseDouble(s);

            } catch (Exception e) {
               // JOptionPane.showMessageDialog(null, e);
            } finally {
                try {
                    pst.close();
                    rs.close();
                } catch (SQLException ex) {
                   // Logger.getLogger(Management.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            try {
                //مرق دجاج
                String sql = "select sum(quantity) from foodInfo where foodType = 'مرق دجاج  ' and month = '" + month + "' and year = '" + year_month + "' ";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                String s = rs.getString("sum(quantity)");
                sum_dajajMarag = Double.parseDouble(s);

            } catch (Exception e) {
               // JOptionPane.showMessageDialog(null, e);
            } finally {
                try {
                    pst.close();
                    rs.close();
                } catch (SQLException ex) {
                   // Logger.getLogger(Management.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        } else if (search_year1.isSelected()) {
            try {
                //سلطة الدجاج المشوي
                String sql = "select sum(quantity) from foodInfo where foodType = 'سلطة الدجاج المشوي' and year = '" + year + "' ";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                String s = rs.getString("sum(quantity)");
                sum_dajajSalad = Double.parseDouble(s);

            } catch (Exception e) {
               // JOptionPane.showMessageDialog(null, e);
            } finally {
                try {
                    pst.close();
                    rs.close();
                } catch (SQLException ex) {
                  //  Logger.getLogger(Management.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            try {
                //مرقوق دجاج
                String sql = "select sum(quantity) from foodInfo where foodType = 'مرقوق دجاج ' and year = '" + year + "' ";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                String s = rs.getString("sum(quantity)");
                sum_dajajMargoog = Double.parseDouble(s);

            } catch (Exception e) {
               // JOptionPane.showMessageDialog(null, e);
            } finally {
                try {
                    pst.close();
                    rs.close();
                } catch (SQLException ex) {
                   // Logger.getLogger(Management.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            try {
                //مجبوس دجاج
                String sql = "select sum(quantity) from foodInfo where foodType = 'مجبوس دجاج' and year = '" + year + "' ";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                String s = rs.getString("sum(quantity)");
                sum_dajajMajboos = Double.parseDouble(s);

            } catch (Exception e) {
               // JOptionPane.showMessageDialog(null, e);
            } finally {
                try {
                    pst.close();
                    rs.close();
                } catch (SQLException ex) {
                   // Logger.getLogger(Management.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            try {
                //مرق دجاج
                String sql = "select sum(quantity) from foodInfo where foodType = 'مرق دجاج  ' and year = '" + year + "' ";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                String s = rs.getString("sum(quantity)");
                sum_dajajMarag = Double.parseDouble(s);

            } catch (Exception e) {
               // JOptionPane.showMessageDialog(null, e);
            } finally {
                try {
                    pst.close();
                    rs.close();
                } catch (SQLException ex) {
                  //  Logger.getLogger(Management.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
    }

    private void select_type5(String date, String month, String year_month, String year) {
        if (search_day1.isSelected()) {
            try {
                //مجبوس لحم
                String sql = "select sum(quantity) from foodInfo where foodType = 'مجبوس لحم' and date = '" + date + "' ";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                String s = rs.getString("sum(quantity)");
                sum_majboosLaham = Double.parseDouble(s);

            } catch (Exception e) {
                //JOptionPane.showMessageDialog(null, e);
            } finally {
                try {
                    pst.close();
                    rs.close();
                } catch (SQLException ex) {
                   // Logger.getLogger(Management.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            try {
                //برياني لحم
                String sql = "select sum(quantity) from foodInfo where foodType = 'برياني لحم' and date = '" + date + "' ";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                String s = rs.getString("sum(quantity)");
                sum_bryaniLaham = Double.parseDouble(s);

            } catch (Exception e) {
               // JOptionPane.showMessageDialog(null, e);
            } finally {
                try {
                    pst.close();
                    rs.close();
                } catch (SQLException ex) {
                   // Logger.getLogger(Management.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            try {
                //مرق لحم
                String sql = "select sum(quantity) from foodInfo where foodType = 'مرق لحم' and date = '" + date + "' ";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                String s = rs.getString("sum(quantity)");
                sum_maragLaham = Double.parseDouble(s);

            } catch (Exception e) {
               // JOptionPane.showMessageDialog(null, e);
            } finally {
                try {
                    pst.close();
                    rs.close();
                } catch (SQLException ex) {
                   // Logger.getLogger(Management.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        } else if (search_month1.isSelected()) {
            try {
                //مجبوس لحم
                String sql = "select sum(quantity) from foodInfo where foodType = 'مجبوس لحم' and month = '" + month + "' and year = '" + year_month + "' ";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                String s = rs.getString("sum(quantity)");
                sum_majboosLaham = Double.parseDouble(s);

            } catch (Exception e) {
              //  JOptionPane.showMessageDialog(null, e);
            } finally {
                try {
                    pst.close();
                    rs.close();
                } catch (SQLException ex) {
                   // Logger.getLogger(Management.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            try {
                //برياني لحم
                String sql = "select sum(quantity) from foodInfo where foodType = 'برياني لحم' and month = '" + month + "' and year = '" + year_month + "' ";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                String s = rs.getString("sum(quantity)");
                sum_bryaniLaham = Double.parseDouble(s);

            } catch (Exception e) {
               // JOptionPane.showMessageDialog(null, e);
            } finally {
                try {
                    pst.close();
                    rs.close();
                } catch (SQLException ex) {
                   // Logger.getLogger(Management.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            try {
                //مرق لحم
                String sql = "select sum(quantity) from foodInfo where foodType = 'مرق لحم' and month = '" + month + "' and year = '" + year_month + "' ";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                String s = rs.getString("sum(quantity)");
                sum_maragLaham = Double.parseDouble(s);

            } catch (Exception e) {
              //  JOptionPane.showMessageDialog(null, e);
            } finally {
                try {
                    pst.close();
                    rs.close();
                } catch (SQLException ex) {
                  //  Logger.getLogger(Management.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        } else if (search_year1.isSelected()) {
            try {
                //مجبوس لحم
                String sql = "select sum(quantity) from foodInfo where foodType = 'مجبوس لحم' and year = '" + year + "' ";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                String s = rs.getString("sum(quantity)");
                sum_majboosLaham = Double.parseDouble(s);

            } catch (Exception e) {
               // JOptionPane.showMessageDialog(null, e);
            } finally {
                try {
                    pst.close();
                    rs.close();
                } catch (SQLException ex) {
                   // Logger.getLogger(Management.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            try {
                //برياني لحم
                String sql = "select sum(quantity) from foodInfo where foodType = 'برياني لحم' and year = '" + year + "' ";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                String s = rs.getString("sum(quantity)");
                sum_bryaniLaham = Double.parseDouble(s);

            } catch (Exception e) {
              //  JOptionPane.showMessageDialog(null, e);
            } finally {
                try {
                    pst.close();
                    rs.close();
                } catch (SQLException ex) {
                   // Logger.getLogger(Management.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            try {
                //مرق لحم
                String sql = "select sum(quantity) from foodInfo where foodType = 'مرق لحم' and year = '" + year + "' ";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                String s = rs.getString("sum(quantity)");
                sum_maragLaham = Double.parseDouble(s);

            } catch (Exception e) {
               // JOptionPane.showMessageDialog(null, e);
            } finally {
                try {
                    pst.close();
                    rs.close();
                } catch (SQLException ex) {
                   // Logger.getLogger(Management.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        }
    }

    private void select_type6(String date, String month, String year_month, String year) {
        if (search_day1.isSelected()) {
            try {
                //أرز ابيض
                String sql = "select sum(quantity) from foodInfo where foodType = 'أرز أبيض' and date = '" + date + "' ";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                String s = rs.getString("sum(quantity)");
                sum_whiteRice = Double.parseDouble(s);

            } catch (Exception e) {
               // JOptionPane.showMessageDialog(null, e);
            } finally {
                try {
                    pst.close();
                    rs.close();
                } catch (SQLException ex) {
                  //  Logger.getLogger(Management.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            try {
                //أرز بالشعيرية
                String sql = "select sum(quantity) from foodInfo where foodType = 'أرز بالشعيرية' and date = '" + date + "' ";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                String s = rs.getString("sum(quantity)");
                sum_sheriaRice = Double.parseDouble(s);

            } catch (Exception e) {
               // JOptionPane.showMessageDialog(null, e);
            } finally {
                try {
                    pst.close();
                    rs.close();
                } catch (SQLException ex) {
                  //  Logger.getLogger(Management.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            try {
                //أرز بالعدس
                String sql = "select sum(quantity) from foodInfo where foodType = 'أرز بالعدس' and date = '" + date + "' ";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                String s = rs.getString("sum(quantity)");
                sum_adasRice = Double.parseDouble(s);

            } catch (Exception e) {
               // JOptionPane.showMessageDialog(null, e);
            } finally {
                try {
                    pst.close();
                    rs.close();
                } catch (SQLException ex) {
                   // Logger.getLogger(Management.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        } else if (search_month1.isSelected()) {
            try {
                //أرز ابيض
                String sql = "select sum(quantity) from foodInfo where foodType = 'أرز أبيض' and month = '" + month + "' and year = '" + year_month + "' ";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                String s = rs.getString("sum(quantity)");
                sum_whiteRice = Double.parseDouble(s);

            } catch (Exception e) {
              //  JOptionPane.showMessageDialog(null, e);
            } finally {
                try {
                    pst.close();
                    rs.close();
                } catch (SQLException ex) {
                  //  Logger.getLogger(Management.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            try {
                //أرز بالشعيرية
                String sql = "select sum(quantity) from foodInfo where foodType = 'أرز بالشعيرية' and month = '" + month + "' and year = '" + year_month + "' ";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                String s = rs.getString("sum(quantity)");
                sum_sheriaRice = Double.parseDouble(s);

            } catch (Exception e) {
               // JOptionPane.showMessageDialog(null, e);
            } finally {
                try {
                    pst.close();
                    rs.close();
                } catch (SQLException ex) {
                   // Logger.getLogger(Management.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            try {
                //أرز بالعدس
                String sql = "select sum(quantity) from foodInfo where foodType = 'أرز بالعدس' and month = '" + month + "' and year = '" + year_month + "' ";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                String s = rs.getString("sum(quantity)");
                sum_adasRice = Double.parseDouble(s);

            } catch (Exception e) {
                //JOptionPane.showMessageDialog(null, e);
            } finally {
                try {
                    pst.close();
                    rs.close();
                } catch (SQLException ex) {
                  //  Logger.getLogger(Management.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        } else if (search_year1.isSelected()) {
            try {
                //أرز ابيض
                String sql = "select sum(quantity) from foodInfo where foodType = 'أرز أبيض' and year = '" + year + "' ";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                String s = rs.getString("sum(quantity)");
                sum_whiteRice = Double.parseDouble(s);

            } catch (Exception e) {
               // JOptionPane.showMessageDialog(null, e);
            } finally {
                try {
                    pst.close();
                    rs.close();
                } catch (SQLException ex) {
                   // Logger.getLogger(Management.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            try {
                //أرز بالشعيرية
                String sql = "select sum(quantity) from foodInfo where foodType = 'أرز بالشعيرية' and year = '" + year + "' ";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                String s = rs.getString("sum(quantity)");
                sum_sheriaRice = Double.parseDouble(s);

            } catch (Exception e) {
                //JOptionPane.showMessageDialog(null, e);
            } finally {
                try {
                    pst.close();
                    rs.close();
                } catch (SQLException ex) {
                   // Logger.getLogger(Management.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            try {
                //أرز بالعدس
                String sql = "select sum(quantity) from foodInfo where foodType = 'أرز بالعدس' and year = '" + year + "' ";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                String s = rs.getString("sum(quantity)");
                sum_adasRice = Double.parseDouble(s);

            } catch (Exception e) {
                //JOptionPane.showMessageDialog(null, e);
            } finally {
                try {
                    pst.close();
                    rs.close();
                } catch (SQLException ex) {
                   // Logger.getLogger(Management.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        }
    }

    private void select_type7(String date, String month, String year_month, String year) {
        if (search_day1.isSelected()) {
            try {
                //فتوش
                String sql = "select sum(quantity) from foodInfo where foodType = 'فتوش' and date = '" + date + "' ";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                String s = rs.getString("sum(quantity)");
                sum_fatoosh = Double.parseDouble(s);

            } catch (Exception e) {
               // JOptionPane.showMessageDialog(null, e);
            } finally {
                try {
                    pst.close();
                    rs.close();
                } catch (SQLException ex) {
                   // Logger.getLogger(Management.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            try {
                //سلطة الملفوف
                String sql = "select sum(quantity) from foodInfo where foodType = 'سلطة الملفوف' and date = '" + date + "' ";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                String s = rs.getString("sum(quantity)");
                sum_malfoofSalad = Double.parseDouble(s);

            } catch (Exception e) {
               // JOptionPane.showMessageDialog(null, e);
            } finally {
                try {
                    pst.close();
                    rs.close();
                } catch (SQLException ex) {
                   // Logger.getLogger(Management.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            try {
                //تبولة
                String sql = "select sum(quantity) from foodInfo where foodType = 'تبولة' and date = '" + date + "' ";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                String s = rs.getString("sum(quantity)");
                sum_tabolah = Double.parseDouble(s);

            } catch (Exception e) {
               // JOptionPane.showMessageDialog(null, e);
            } finally {
                try {
                    pst.close();
                    rs.close();
                } catch (SQLException ex) {
                  //  Logger.getLogger(Management.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            try {
                // سلطة خضراء
                String sql = "select sum(quantity) from foodInfo where foodType = 'سلطة خضراء' and date = '" + date + "' ";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                String s = rs.getString("sum(quantity)");
                sum_greenSalad = Double.parseDouble(s);

            } catch (Exception e) {
               // JOptionPane.showMessageDialog(null, e);
            } finally {
                try {
                    pst.close();
                    rs.close();
                } catch (SQLException ex) {
                   // Logger.getLogger(Management.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            try {
                // سلطة التونة
                String sql = "select sum(quantity) from foodInfo where foodType = 'سلطة التونة' and date = '" + date + "' ";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                String s = rs.getString("sum(quantity)");
                sum_tunaSalad = Double.parseDouble(s);

            } catch (Exception e) {
              //  JOptionPane.showMessageDialog(null, e);
            } finally {
                try {
                    pst.close();
                    rs.close();
                } catch (SQLException ex) {
                   // Logger.getLogger(Management.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            try {
                // سلطة البطاطس
                String sql = "select sum(quantity) from foodInfo where foodType = 'سلطة البطاطس' and date = '" + date + "' ";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                String s = rs.getString("sum(quantity)");
                sum_PotatosSalad = Double.parseDouble(s);

            } catch (Exception e) {
               // JOptionPane.showMessageDialog(null, e);
            } finally {
                try {
                    pst.close();
                    rs.close();
                } catch (SQLException ex) {
                   // Logger.getLogger(Management.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            try {
                // سلطة سيزر
                String sql = "select sum(quantity) from foodInfo where foodType = 'سلطة سيزر' and date = '" + date + "' ";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                String s = rs.getString("sum(quantity)");
                sum_ceserSalad = Double.parseDouble(s);

            } catch (Exception e) {
               // JOptionPane.showMessageDialog(null, e);
            } finally {
                try {
                    pst.close();
                    rs.close();
                } catch (SQLException ex) {
                   // Logger.getLogger(Management.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            try {
                // سلطة المعكرونة
                String sql = "select sum(quantity) from foodInfo where foodType = 'سلطة المعكرونة' and date = '" + date + "' ";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                String s = rs.getString("sum(quantity)");
                sum_makaronahsSalad = Double.parseDouble(s);

            } catch (Exception e) {
               // JOptionPane.showMessageDialog(null, e);
            } finally {
                try {
                    pst.close();
                    rs.close();
                } catch (SQLException ex) {
                   // Logger.getLogger(Management.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        } else if (search_month1.isSelected()) {
            try {
                //فتوش
                String sql = "select sum(quantity) from foodInfo where foodType = 'فتوش' and month = '" + month + "' and year = '" + year_month + "' ";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                String s = rs.getString("sum(quantity)");
                sum_fatoosh = Double.parseDouble(s);

            } catch (Exception e) {
               // JOptionPane.showMessageDialog(null, e);
            } finally {
                try {
                    pst.close();
                    rs.close();
                } catch (SQLException ex) {
                  //  Logger.getLogger(Management.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            try {
                //سلطة الملفوف
                String sql = "select sum(quantity) from foodInfo where foodType = 'سلطة الملفوف' and month = '" + month + "' and year = '" + year_month + "' ";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                String s = rs.getString("sum(quantity)");
                sum_malfoofSalad = Double.parseDouble(s);

            } catch (Exception e) {
               // JOptionPane.showMessageDialog(null, e);
            } finally {
                try {
                    pst.close();
                    rs.close();
                } catch (SQLException ex) {
                  //  Logger.getLogger(Management.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            try {
                //تبولة
                String sql = "select sum(quantity) from foodInfo where foodType = 'تبولة' and month = '" + month + "' and year = '" + year_month + "' ";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                String s = rs.getString("sum(quantity)");
                sum_tabolah = Double.parseDouble(s);

            } catch (Exception e) {
               // JOptionPane.showMessageDialog(null, e);
            } finally {
                try {
                    pst.close();
                    rs.close();
                } catch (SQLException ex) {
                  //  Logger.getLogger(Management.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            try {
                // سلطة خضراء
                String sql = "select sum(quantity) from foodInfo where foodType = 'سلطة خضراء' and month = '" + month + "' and year = '" + year_month + "' ";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                String s = rs.getString("sum(quantity)");
                sum_greenSalad = Double.parseDouble(s);

            } catch (Exception e) {
               // JOptionPane.showMessageDialog(null, e);
            } finally {
                try {
                    pst.close();
                    rs.close();
                } catch (SQLException ex) {
                   // Logger.getLogger(Management.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            try {
                // سلطة التونة
                String sql = "select sum(quantity) from foodInfo where foodType = 'سلطة التونة' and month = '" + month + "' and year = '" + year_month + "' ";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                String s = rs.getString("sum(quantity)");
                sum_tunaSalad = Double.parseDouble(s);

            } catch (Exception e) {
               // JOptionPane.showMessageDialog(null, e);
            } finally {
                try {
                    pst.close();
                    rs.close();
                } catch (SQLException ex) {
                  //  Logger.getLogger(Management.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            try {
                // سلطة البطاطس
                String sql = "select sum(quantity) from foodInfo where foodType = 'سلطة البطاطس' and month = '" + month + "' and year = '" + year_month + "' ";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                String s = rs.getString("sum(quantity)");
                sum_PotatosSalad = Double.parseDouble(s);

            } catch (Exception e) {
               // JOptionPane.showMessageDialog(null, e);
            } finally {
                try {
                    pst.close();
                    rs.close();
                } catch (SQLException ex) {
                   // Logger.getLogger(Management.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            try {
                // سلطة سيزر
                String sql = "select sum(quantity) from foodInfo where foodType = 'سلطة سيزر' and month = '" + month + "' and year = '" + year_month + "' ";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                String s = rs.getString("sum(quantity)");
                sum_ceserSalad = Double.parseDouble(s);

            } catch (Exception e) {
              //  JOptionPane.showMessageDialog(null, e);
            } finally {
                try {
                    pst.close();
                    rs.close();
                } catch (SQLException ex) {
                    //Logger.getLogger(Management.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            try {
                // سلطة المعكرونة
                String sql = "select sum(quantity) from foodInfo where foodType = 'سلطة المعكرونة' and month = '" + month + "' and year = '" + year_month + "' ";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                String s = rs.getString("sum(quantity)");
                sum_makaronahsSalad = Double.parseDouble(s);

            } catch (Exception e) {
              //  JOptionPane.showMessageDialog(null, e);
            } finally {
                try {
                    pst.close();
                    rs.close();
                } catch (SQLException ex) {
                 //   Logger.getLogger(Management.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        } else if (search_year1.isSelected()) {

            try {
                //فتوش
                String sql = "select sum(quantity) from foodInfo where foodType = 'فتوش' and year = '" + year + "' ";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                String s = rs.getString("sum(quantity)");
                sum_fatoosh = Double.parseDouble(s);

            } catch (Exception e) {
              //  JOptionPane.showMessageDialog(null, e);
            } finally {
                try {
                    pst.close();
                    rs.close();
                } catch (SQLException ex) {
                   // Logger.getLogger(Management.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            try {
                //سلطة الملفوف
                String sql = "select sum(quantity) from foodInfo where foodType = 'سلطة الملفوف' and year = '" + year + "' ";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                String s = rs.getString("sum(quantity)");
                sum_malfoofSalad = Double.parseDouble(s);

            } catch (Exception e) {
               // JOptionPane.showMessageDialog(null, e);
            } finally {
                try {
                    pst.close();
                    rs.close();
                } catch (SQLException ex) {
                   // Logger.getLogger(Management.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            try {
                //تبولة
                String sql = "select sum(quantity) from foodInfo where foodType = 'تبولة' and year = '" + year + "' ";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                String s = rs.getString("sum(quantity)");
                sum_tabolah = Double.parseDouble(s);

            } catch (Exception e) {
              //  JOptionPane.showMessageDialog(null, e);
            } finally {
                try {
                    pst.close();
                    rs.close();
                } catch (SQLException ex) {
                   // Logger.getLogger(Management.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            try {
                // سلطة خضراء
                String sql = "select sum(quantity) from foodInfo where foodType = 'سلطة خضراء' and year = '" + year + "' ";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                String s = rs.getString("sum(quantity)");
                sum_greenSalad = Double.parseDouble(s);

            } catch (Exception e) {
              //  JOptionPane.showMessageDialog(null, e);
            } finally {
                try {
                    pst.close();
                    rs.close();
                } catch (SQLException ex) {
                   // Logger.getLogger(Management.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            try {
                // سلطة التونة
                String sql = "select sum(quantity) from foodInfo where foodType = 'سلطة التونة' and year = '" + year + "' ";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                String s = rs.getString("sum(quantity)");
                sum_tunaSalad = Double.parseDouble(s);

            } catch (Exception e) {
               // JOptionPane.showMessageDialog(null, e);
            } finally {
                try {
                    pst.close();
                    rs.close();
                } catch (SQLException ex) {
                   // Logger.getLogger(Management.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            try {
                // سلطة البطاطس
                String sql = "select sum(quantity) from foodInfo where foodType = 'سلطة البطاطس' and year = '" + year + "' ";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                String s = rs.getString("sum(quantity)");
                sum_PotatosSalad = Double.parseDouble(s);

            } catch (Exception e) {
               // JOptionPane.showMessageDialog(null, e);
            } finally {
                try {
                    pst.close();
                    rs.close();
                } catch (SQLException ex) {
                   // Logger.getLogger(Management.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            try {
                // سلطة سيزر
                String sql = "select sum(quantity) from foodInfo where foodType = 'سلطة سيزر' and year = '" + year + "' ";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                String s = rs.getString("sum(quantity)");
                sum_ceserSalad = Double.parseDouble(s);

            } catch (Exception e) {
               // JOptionPane.showMessageDialog(null, e);
            } finally {
                try {
                    pst.close();
                    rs.close();
                } catch (SQLException ex) {
                  //  Logger.getLogger(Management.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            try {
                // سلطة المعكرونة
                String sql = "select sum(quantity) from foodInfo where foodType = 'سلطة المعكرونة' and year = '" + year + "' ";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                String s = rs.getString("sum(quantity)");
                sum_makaronahsSalad = Double.parseDouble(s);

            } catch (Exception e) {
               // JOptionPane.showMessageDialog(null, e);
            } finally {
                try {
                    pst.close();
                    rs.close();
                } catch (SQLException ex) {
                  //  Logger.getLogger(Management.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        }
    }

    private void select_type8(String date, String month, String year_month, String year) {
        if (search_day1.isSelected()) {
            try {
                //مياه معدنية
                String sql = "select sum(quantity) from foodInfo where foodType = 'مياه معدنية' and date = '" + date + "' ";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                String s = rs.getString("sum(quantity)");
                sum_water = Double.parseDouble(s);

            } catch (Exception e) {
               // JOptionPane.showMessageDialog(null, e);
            } finally {
                try {
                    pst.close();
                    rs.close();
                } catch (SQLException ex) {
                  //  Logger.getLogger(Management.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            try {
                //شاي بدون سكر
                String sql = "select sum(quantity) from foodInfo where foodType = 'شاي بدون سكر' and date = '" + date + "' ";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                String s = rs.getString("sum(quantity)");
                sum_tea = Double.parseDouble(s);

            } catch (Exception e) {
               // JOptionPane.showMessageDialog(null, e);
            } finally {
                try {
                    pst.close();
                    rs.close();
                } catch (SQLException ex) {
                  //  Logger.getLogger(Management.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            try {
                //قهوة تركية
                String sql = "select sum(quantity) from foodInfo where foodType = 'قهوة تركية' and date = '" + date + "' ";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                String s = rs.getString("sum(quantity)");
                sum_turkishcoffee = Double.parseDouble(s);

            } catch (Exception e) {
               // JOptionPane.showMessageDialog(null, e);
            } finally {
                try {
                    pst.close();
                    rs.close();
                } catch (SQLException ex) {
                  //  Logger.getLogger(Management.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            try {
                //قهوة نسكافيه بدون سكر 
                String sql = "select sum(quantity) from foodInfo where foodType = 'قهوة نسكافيه بدون سكر' and date = '" + date + "' ";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                String s = rs.getString("sum(quantity)");
                sum_coffee = Double.parseDouble(s);

            } catch (Exception e) {
              //  JOptionPane.showMessageDialog(null, e);
            } finally {
                try {
                    pst.close();
                    rs.close();
                } catch (SQLException ex) {
                 //   Logger.getLogger(Management.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        } else if (search_month1.isSelected()) {
            try {
                //مياه معدنية
                String sql = "select sum(quantity) from foodInfo where foodType = 'مياه معدنية' and month = '" + month + "' and year = '" + year_month + "'  ";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                String s = rs.getString("sum(quantity)");
                sum_water = Double.parseDouble(s);

            } catch (Exception e) {
              //  JOptionPane.showMessageDialog(null, e);
            } finally {
                try {
                    pst.close();
                    rs.close();
                } catch (SQLException ex) {
                  //  Logger.getLogger(Management.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            try {
                //شاي بدون سكر
                String sql = "select sum(quantity) from foodInfo where foodType = 'شاي بدون سكر' and month = '" + month + "' and year = '" + year_month + "'  ";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                String s = rs.getString("sum(quantity)");
                sum_tea = Double.parseDouble(s);

            } catch (Exception e) {
               // JOptionPane.showMessageDialog(null, e);
            } finally {
                try {
                    pst.close();
                    rs.close();
                } catch (SQLException ex) {
                   // Logger.getLogger(Management.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            try {
                //قهوة تركية
                String sql = "select sum(quantity) from foodInfo where foodType = 'قهوة تركية' and month = '" + month + "' and year = '" + year_month + "'  ";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                String s = rs.getString("sum(quantity)");
                sum_turkishcoffee = Double.parseDouble(s);

            } catch (Exception e) {
               // JOptionPane.showMessageDialog(null, e);
            } finally {
                try {
                    pst.close();
                    rs.close();
                } catch (SQLException ex) {
                   // Logger.getLogger(Management.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            try {
                //قهوة نسكافيه بدون سكر 
                String sql = "select sum(quantity) from foodInfo where foodType = 'قهوة نسكافيه بدون سكر' and month = '" + month + "' and year = '" + year_month + "'  ";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                String s = rs.getString("sum(quantity)");
                sum_coffee = Double.parseDouble(s);

            } catch (Exception e) {
                //JOptionPane.showMessageDialog(null, e);
            } finally {
                try {
                    pst.close();
                    rs.close();
                } catch (SQLException ex) {
                  //  Logger.getLogger(Management.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        } else if (search_year1.isSelected()) {
            try {
                //مياه معدنية
                String sql = "select sum(quantity) from foodInfo where foodType = 'مياه معدنية' and year = '" + year + "' ";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                String s = rs.getString("sum(quantity)");
                sum_water = Double.parseDouble(s);

            } catch (Exception e) {
               // JOptionPane.showMessageDialog(null, e);
            } finally {
                try {
                    pst.close();
                    rs.close();
                } catch (SQLException ex) {
                   // Logger.getLogger(Management.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            try {
                //شاي بدون سكر
                String sql = "select sum(quantity) from foodInfo where foodType = 'شاي بدون سكر' and year = '" + year + "' ";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                String s = rs.getString("sum(quantity)");
                sum_tea = Double.parseDouble(s);

            } catch (Exception e) {
               // JOptionPane.showMessageDialog(null, e);
            } finally {
                try {
                    pst.close();
                    rs.close();
                } catch (SQLException ex) {
                   // Logger.getLogger(Management.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            try {
                //قهوة تركية
                String sql = "select sum(quantity) from foodInfo where foodType = 'قهوة تركية' and year = '" + year + "' ";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                String s = rs.getString("sum(quantity)");
                sum_turkishcoffee = Double.parseDouble(s);

            } catch (Exception e) {
               // JOptionPane.showMessageDialog(null, e);
            } finally {
                try {
                    pst.close();
                    rs.close();
                } catch (SQLException ex) {
                  //  Logger.getLogger(Management.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            try {
                //قهوة نسكافيه بدون سكر 
                String sql = "select sum(quantity) from foodInfo where foodType = 'قهوة نسكافيه بدون سكر' and year = '" + year + "' ";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                String s = rs.getString("sum(quantity)");
                sum_coffee = Double.parseDouble(s);

            } catch (Exception e) {
               // JOptionPane.showMessageDialog(null, e);
            } finally {
                try {
                    pst.close();
                    rs.close();
                } catch (SQLException ex) {
                   // Logger.getLogger(Management.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        }
    }

    private void select_type9(String date, String month, String year_month, String year) {
        if (search_day1.isSelected()) {
            try {
                //عصير تفاح طازج
                String sql = "select sum(quantity) from foodInfo where foodType = 'عصير تفاح طازج' and date = '" + date + "' ";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                String s = rs.getString("sum(quantity)");
                sum_appleJuice = Double.parseDouble(s);

            } catch (Exception e) {
               // JOptionPane.showMessageDialog(null, e);
            } finally {
                try {
                    pst.close();
                    rs.close();
                } catch (SQLException ex) {
                   // Logger.getLogger(Management.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            try {
                //عصير برتقال طازج
                String sql = "select sum(quantity) from foodInfo where foodType = 'عصير برتقال طازج' and date = '" + date + "' ";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                String s = rs.getString("sum(quantity)");
                sum_orangeJuice = Double.parseDouble(s);

            } catch (Exception e) {
              //  JOptionPane.showMessageDialog(null, e);
            } finally {
                try {
                    pst.close();
                    rs.close();
                } catch (SQLException ex) {
                   // Logger.getLogger(Management.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            try {
                //عصير أناناس طازج
                String sql = "select sum(quantity) from foodInfo where foodType = 'عصير أناناس طازج' and date = '" + date + "' ";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                String s = rs.getString("sum(quantity)");
                sum_pineappleJuice = Double.parseDouble(s);

            } catch (Exception e) {
              //  JOptionPane.showMessageDialog(null, e);
            } finally {
                try {
                    pst.close();
                    rs.close();
                } catch (SQLException ex) {
                   // Logger.getLogger(Management.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            try {
                //عصير عنب احمر طازج
                String sql = "select sum(quantity) from foodInfo where foodType = 'عصير عنب أحمر طازج' and date = '" + date + "' ";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                String s = rs.getString("sum(quantity)");
                sum_redGrabesJuice = Double.parseDouble(s);

            } catch (Exception e) {
              //  JOptionPane.showMessageDialog(null, e);
            } finally {
                try {
                    pst.close();
                    rs.close();
                } catch (SQLException ex) {
                   // Logger.getLogger(Management.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            try {
                //عصير رمان طازج
                String sql = "select sum(quantity) from foodInfo where foodType = 'عصير رمان طازج' and date = '" + date + "' ";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                String s = rs.getString("sum(quantity)");
                sum_pomegranateJuice = Double.parseDouble(s);

            } catch (Exception e) {
               // JOptionPane.showMessageDialog(null, e);
            } finally {
                try {
                    pst.close();
                    rs.close();
                } catch (SQLException ex) {
                  //  Logger.getLogger(Management.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        } else if (search_month1.isSelected()) {

            try {
                //عصير تفاح طازج
                String sql = "select sum(quantity) from foodInfo where foodType = 'عصير تفاح طازج' and month = '" + month + "' and year = '" + year_month + "'  ";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                String s = rs.getString("sum(quantity)");
                sum_appleJuice = Double.parseDouble(s);

            } catch (Exception e) {
               // JOptionPane.showMessageDialog(null, e);
            } finally {
                try {
                    pst.close();
                    rs.close();
                } catch (SQLException ex) {
                  //  Logger.getLogger(Management.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            try {
                //عصير برتقال طازج
                String sql = "select sum(quantity) from foodInfo where foodType = 'عصير برتقال طازج' and month = '" + month + "' and year = '" + year_month + "' ";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                String s = rs.getString("sum(quantity)");
                sum_orangeJuice = Double.parseDouble(s);

            } catch (Exception e) {
               // JOptionPane.showMessageDialog(null, e);
            } finally {
                try {
                    pst.close();
                    rs.close();
                } catch (SQLException ex) {
                 //  Logger.getLogger(Management.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            try {
                //عصير أناناس طازج
                String sql = "select sum(quantity) from foodInfo where foodType = 'عصير أناناس طازج' and month = '" + month + "' and year = '" + year_month + "' ";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                String s = rs.getString("sum(quantity)");
                sum_pineappleJuice = Double.parseDouble(s);

            } catch (Exception e) {
               // JOptionPane.showMessageDialog(null, e);
            } finally {
                try {
                    pst.close();
                    rs.close();
                } catch (SQLException ex) {
                   // Logger.getLogger(Management.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            try {
                //عصير عنب احمر طازج
                String sql = "select sum(quantity) from foodInfo where foodType = 'عصير عنب أحمر طازج' and month = '" + month + "' and year = '" + year_month + "' ";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                String s = rs.getString("sum(quantity)");
                sum_redGrabesJuice = Double.parseDouble(s);

            } catch (Exception e) {
               // JOptionPane.showMessageDialog(null, e);
            } finally {
                try {
                    pst.close();
                    rs.close();
                } catch (SQLException ex) {
                   // Logger.getLogger(Management.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            try {
                //عصير رمان طازج
                String sql = "select sum(quantity) from foodInfo where foodType = 'عصير رمان طازج' and month = '" + month + "' and year = '" + year_month + "' ";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                String s = rs.getString("sum(quantity)");
                sum_pomegranateJuice = Double.parseDouble(s);

            } catch (Exception e) {
               // JOptionPane.showMessageDialog(null, e);
            } finally {
                try {
                    pst.close();
                    rs.close();
                } catch (SQLException ex) {
                   // Logger.getLogger(Management.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        } else if (search_year1.isSelected()) {
            try {
                //عصير تفاح طازج
                String sql = "select sum(quantity) from foodInfo where foodType = 'عصير تفاح طازج' and year = '" + year + "' ";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                String s = rs.getString("sum(quantity)");
                sum_appleJuice = Double.parseDouble(s);

            } catch (Exception e) {
               // JOptionPane.showMessageDialog(null, e);
            } finally {
                try {
                    pst.close();
                    rs.close();
                } catch (SQLException ex) {
                   // Logger.getLogger(Management.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            try {
                //عصير برتقال طازج
                String sql = "select sum(quantity) from foodInfo where foodType = 'عصير برتقال طازج' and year = '" + year + "' ";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                String s = rs.getString("sum(quantity)");
                sum_orangeJuice = Double.parseDouble(s);

            } catch (Exception e) {
               // JOptionPane.showMessageDialog(null, e);
            } finally {
                try {
                    pst.close();
                    rs.close();
                } catch (SQLException ex) {
                   // Logger.getLogger(Management.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            try {
                //عصير أناناس طازج
                String sql = "select sum(quantity) from foodInfo where foodType = 'عصير أناناس طازج' and year = '" + year + "' ";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                String s = rs.getString("sum(quantity)");
                sum_pineappleJuice = Double.parseDouble(s);

            } catch (Exception e) {
               // JOptionPane.showMessageDialog(null, e);
            } finally {
                try {
                    pst.close();
                    rs.close();
                } catch (SQLException ex) {
                   // Logger.getLogger(Management.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            try {
                //عصير عنب احمر طازج
                String sql = "select sum(quantity) from foodInfo where foodType = 'عصير عنب أحمر طازج' and year = '" + year + "' ";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                String s = rs.getString("sum(quantity)");
                sum_redGrabesJuice = Double.parseDouble(s);

            } catch (Exception e) {
               // JOptionPane.showMessageDialog(null, e);
            } finally {
                try {
                    pst.close();
                    rs.close();
                } catch (SQLException ex) {
                    //Logger.getLogger(Management.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            try {
                //عصير رمان طازج
                String sql = "select sum(quantity) from foodInfo where foodType = 'عصير رمان طازج' and year = '" + year + "' ";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                String s = rs.getString("sum(quantity)");
                sum_pomegranateJuice = Double.parseDouble(s);

            } catch (Exception e) {
              //  JOptionPane.showMessageDialog(null, e);
            } finally {
                try {
                    pst.close();
                    rs.close();
                } catch (SQLException ex) {
                  //  Logger.getLogger(Management.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        }
    }

    private void chart_line() {

        int select = combo_chartType.getSelectedIndex();

        if (select == 0 && search_day1.isSelected()) {

            int day1 = Integer.parseInt(day_now.getText());
            int month1 = Integer.parseInt(month_now.getText());
            int year1 = Integer.parseInt(year_now.getText());
            String date = "" + day1 + "/" + month1 + "/" + year1 + "";

            try {

                DefaultCategoryDataset dataset = new DefaultCategoryDataset();

                if (combo_food.getSelectedIndex() == 0) {
                    select_type1(date, "", "", "");
                    dataset.setValue(sum_hms, date, "حمص");
                    dataset.setValue(sum_waragenab, date, "ورق عنب ");
                    dataset.setValue(sum_babagnooj, date, "بابا غنوج");
                    dataset.setValue(sum_labnahthoom, date, "لبنة بالثوم");
                } else if (combo_food.getSelectedIndex() == 1) {
                    select_type2(date, "", "", "");
                    dataset.setValue(sum_shorbahdajajkudar, date, "شوربة دجاج بالخضار");
                    dataset.setValue(sum_shorbahmashroom, date, "شوربة مشروم");
                    dataset.setValue(sum_shorbahkudar, date, "شوربة خضار");
                } else if (combo_food.getSelectedIndex() == 2) {
                    select_type3(date, "", "", "");
                    dataset.setValue(sum_makaronahSaladM, date, "سلطة المعكرونة المشكلة ");
                    dataset.setValue(sum_makaronah, date, "معكرونة سادة");
                } else if (combo_food.getSelectedIndex() == 3) {
                    select_type4(date, "", "", "");
                    dataset.setValue(sum_dajajSalad, date, "سلطة الدجاج المشوي");
                    dataset.setValue(sum_dajajMargoog, date, "مرقوق دجاج ");
                    dataset.setValue(sum_dajajMajboos, date, "مجبوس دجاج");
                    dataset.setValue(sum_dajajMarag, date, "مرق دجاج");
                } else if (combo_food.getSelectedIndex() == 4) {
                    select_type5(date, "", "", "");
                    dataset.setValue(sum_majboosLaham, date, "مجبوس لحم");
                    dataset.setValue(sum_bryaniLaham, date, "برياني لحم");
                    dataset.setValue(sum_maragLaham, date, "مرق لحم");
                } else if (combo_food.getSelectedIndex() == 5) {
                    select_type6(date, "", "", "");
                    dataset.setValue(sum_whiteRice, date, "أرز ابيض");
                    dataset.setValue(sum_sheriaRice, date, "أرز بالشعيرية");
                    dataset.setValue(sum_adasRice, date, "أرز بالعدس");
                } else if (combo_food.getSelectedIndex() == 6) {
                    select_type7(date, "", "", "");
                    dataset.setValue(sum_fatoosh, date, "فتوش");
                    dataset.setValue(sum_malfoofSalad, date, "سلطة الملفوف");
                    dataset.setValue(sum_tabolah, date, "تبولة");
                    dataset.setValue(sum_greenSalad, date, "سلطة خضراء");
                    dataset.setValue(sum_tunaSalad, date, "سلطة التونة");
                    dataset.setValue(sum_PotatosSalad, date, "سلطة البطاطس");
                    dataset.setValue(sum_ceserSalad, date, "سلطة سيزر");
                    dataset.setValue(sum_makaronahsSalad, date, "سلطة المعكرونة");
                } else if (combo_food.getSelectedIndex() == 7) {
                    select_type8(date, "", "", "");
                    dataset.setValue(sum_water, date, "مياه معدنية");
                    dataset.setValue(sum_tea, date, "شاي بدون سكر");
                    dataset.setValue(sum_turkishcoffee, date, "قهوة تركية");
                    dataset.setValue(sum_coffee, date, "قهوة نسكافيه بدون سكر");
                } else if (combo_food.getSelectedIndex() == 8) {
                    select_type9(date, "", "", "");
                    dataset.setValue(sum_appleJuice, date, "عصير تفاح طازج");
                    dataset.setValue(sum_orangeJuice, date, "عصير برتقال طازج");
                    dataset.setValue(sum_pineappleJuice, date, "عصير أناناس طازج");
                    dataset.setValue(sum_redGrabesJuice, date, "عصير عنب احمر طازج");
                    dataset.setValue(sum_pomegranateJuice, date, "عصير رمان طازج ");
                }

                JFreeChart chart = ChartFactory.createLineChart("Food Information in: " + date, "food type", "quantity", dataset, PlotOrientation.VERTICAL, false, true, true);
                BarRenderer renderer = null;
                CategoryPlot plot = null;
                renderer = new BarRenderer();
                ChartFrame frame = new ChartFrame("Line Chart", chart);
                frame.setVisible(true);
                frame.setSize(600, 500);

                if (rad_save.isSelected()) {
                    final ChartRenderingInfo info = new ChartRenderingInfo(new StandardEntityCollection());
                    final File file1 = new File("line chart for food quantites.png ");
                    ChartUtilities.saveChartAsPNG(file1, chart, 1200, 600, info);
                    JOptionPane.showMessageDialog(null, "تم حفظ الصورة بنجاح ");
                }
            } catch (Exception e) {
               // JOptionPane.showMessageDialog(null, e);
            }

        } else if (select == 0 && search_month1.isSelected()) {
            // with month
            String month = combo_month2.getSelectedItem().toString();
            String year_month = month_year.getText();
            try {

                DefaultCategoryDataset dataset = new DefaultCategoryDataset();

                if (combo_food.getSelectedIndex() == 0) {
                    select_type1("", month, year_month, "");
                    dataset.setValue(sum_hms, month, "حمص");
                    dataset.setValue(sum_waragenab, month, "ورق عنب ");
                    dataset.setValue(sum_babagnooj, month, "بابا غنوج");
                    dataset.setValue(sum_labnahthoom, month, "لبنة بالثوم");
                } else if (combo_food.getSelectedIndex() == 1) {
                    select_type2("", month, year_month, "");
                    dataset.setValue(sum_shorbahdajajkudar, month, "شوربة دجاج بالخضار");
                    dataset.setValue(sum_shorbahmashroom, month, "شوربة مشروم");
                    dataset.setValue(sum_shorbahkudar, month, "شوربة خضار");
                } else if (combo_food.getSelectedIndex() == 2) {
                    select_type3("", month, year_month, "");
                    dataset.setValue(sum_makaronahSaladM, month, "سلطة المعكرونة المشكلة ");
                    dataset.setValue(sum_makaronah, month, "معكرونة سادة");
                } else if (combo_food.getSelectedIndex() == 3) {
                    select_type4("", month, year_month, "");
                    dataset.setValue(sum_dajajSalad, month, "سلطة الدجاج المشوي");
                    dataset.setValue(sum_dajajMargoog, month, "مرقوق دجاج ");
                    dataset.setValue(sum_dajajMajboos, month, "مجبوس دجاج");
                    dataset.setValue(sum_dajajMarag, month, "مرق دجاج");
                } else if (combo_food.getSelectedIndex() == 4) {
                    select_type5("", month, year_month, "");
                    dataset.setValue(sum_majboosLaham, month, "مجبوس لحم");
                    dataset.setValue(sum_bryaniLaham, month, "برياني لحم");
                    dataset.setValue(sum_maragLaham, month, "مرق لحم");
                } else if (combo_food.getSelectedIndex() == 5) {
                    select_type6("", month, year_month, "");
                    dataset.setValue(sum_whiteRice, month, "أرز ابيض");
                    dataset.setValue(sum_sheriaRice, month, "أرز بالشعيرية");
                    dataset.setValue(sum_adasRice, month, "أرز بالعدس");
                } else if (combo_food.getSelectedIndex() == 6) {
                    select_type7("", month, year_month, "");

                    dataset.setValue(sum_fatoosh, month, "فتوش");
                    dataset.setValue(sum_malfoofSalad, month, "سلطة الملفوف");
                    dataset.setValue(sum_tabolah, month, "تبولة");
                    dataset.setValue(sum_greenSalad, month, "سلطة خضراء");
                    dataset.setValue(sum_tunaSalad, month, "سلطة التونة");
                    dataset.setValue(sum_PotatosSalad, month, "سلطة البطاطس");
                    dataset.setValue(sum_ceserSalad, month, "سلطة سيزر");
                    dataset.setValue(sum_makaronahsSalad, month, "سلطة المعكرونة");
                } else if (combo_food.getSelectedIndex() == 7) {
                    select_type8("", month, year_month, "");
                    dataset.setValue(sum_water, month, "مياه معدنية");
                    dataset.setValue(sum_tea, month, "شاي بدون سكر");
                    dataset.setValue(sum_turkishcoffee, month, "قهوة تركية");
                    dataset.setValue(sum_coffee, month, "قهوة نسكافيه بدون سكر");
                } else if (combo_food.getSelectedIndex() == 8) {
                    select_type9("", month, year_month, "");
                    dataset.setValue(sum_appleJuice, month, "عصير تفاح طازج");
                    dataset.setValue(sum_orangeJuice, month, "عصير برتقال طازج");
                    dataset.setValue(sum_pineappleJuice, month, "عصير أناناس طازج");
                    dataset.setValue(sum_redGrabesJuice, month, "عصير عنب احمر طازج");
                    dataset.setValue(sum_pomegranateJuice, month, "عصير رمان طازج ");
                }

                JFreeChart chart = ChartFactory.createLineChart("Food Information in: " + month, "food type", "quantity", dataset, PlotOrientation.VERTICAL, false, true, true);
                BarRenderer renderer = null;
                CategoryPlot plot = null;
                renderer = new BarRenderer();
                ChartFrame frame = new ChartFrame("Line Chart", chart);
                frame.setVisible(true);
                frame.setSize(600, 500);

                if (rad_save.isSelected()) {
                    final ChartRenderingInfo info = new ChartRenderingInfo(new StandardEntityCollection());
                    final File file1 = new File("line chart for food quantites.png ");
                    ChartUtilities.saveChartAsPNG(file1, chart, 1200, 600, info);
                    JOptionPane.showMessageDialog(null, "تم حفظ الصورة بنجاح ");
                }
            } catch (Exception e) {
                //JOptionPane.showMessageDialog(null, e);
            }
        } else if (select == 0 && search_year1.isSelected()) {
            // with year
            String year = year_txt1.getText();
            try {

                DefaultCategoryDataset dataset = new DefaultCategoryDataset();

                if (combo_food.getSelectedIndex() == 0) {
                    select_type1("", "", "", year);
                    dataset.setValue(sum_hms, year, "حمص");
                    dataset.setValue(sum_waragenab, year, "ورق عنب ");
                    dataset.setValue(sum_babagnooj, year, "بابا غنوج");
                    dataset.setValue(sum_labnahthoom, year, "لبنة بالثوم");
                } else if (combo_food.getSelectedIndex() == 1) {
                    select_type2("", "", "", year);
                    dataset.setValue(sum_shorbahdajajkudar, year, "شوربة دجاج بالخضار");
                    dataset.setValue(sum_shorbahmashroom, year, "شوربة مشروم");
                    dataset.setValue(sum_shorbahkudar, year, "شوربة خضار");
                } else if (combo_food.getSelectedIndex() == 2) {
                    select_type3("", "", "", year);
                    dataset.setValue(sum_makaronahSaladM, year, "سلطة المعكرونة المشكلة ");
                    dataset.setValue(sum_makaronah, year, "معكرونة سادة");
                } else if (combo_food.getSelectedIndex() == 3) {
                    select_type4("", "", "", year);
                    dataset.setValue(sum_dajajSalad, year, "سلطة الدجاج المشوي");
                    dataset.setValue(sum_dajajMargoog, year, "مرقوق دجاج ");
                    dataset.setValue(sum_dajajMajboos, year, "مجبوس دجاج");
                    dataset.setValue(sum_dajajMarag, year, "مرق دجاج");
                } else if (combo_food.getSelectedIndex() == 4) {
                    select_type5("", "", "", year);
                    dataset.setValue(sum_majboosLaham, year, "مجبوس لحم");
                    dataset.setValue(sum_bryaniLaham, year, "برياني لحم");
                    dataset.setValue(sum_maragLaham, year, "مرق لحم");
                } else if (combo_food.getSelectedIndex() == 5) {
                    select_type6("", "", "", year);
                    dataset.setValue(sum_whiteRice, year, "أرز ابيض");
                    dataset.setValue(sum_sheriaRice, year, "أرز بالشعيرية");
                    dataset.setValue(sum_adasRice, year, "أرز بالعدس");
                } else if (combo_food.getSelectedIndex() == 6) {
                    select_type7("", "", "", year);
                    dataset.setValue(sum_fatoosh, year, "فتوش");
                    dataset.setValue(sum_malfoofSalad, year, "سلطة الملفوف");
                    dataset.setValue(sum_tabolah, year, "تبولة");
                    dataset.setValue(sum_greenSalad, year, "سلطة خضراء");
                    dataset.setValue(sum_tunaSalad, year, "سلطة التونة");
                    dataset.setValue(sum_PotatosSalad, year, "سلطة البطاطس");
                    dataset.setValue(sum_ceserSalad, year, "سلطة سيزر");
                    dataset.setValue(sum_makaronahsSalad, year, "سلطة المعكرونة");
                } else if (combo_food.getSelectedIndex() == 7) {
                    select_type8("", "", "", year);
                    dataset.setValue(sum_water, year, "مياه معدنية");
                    dataset.setValue(sum_tea, year, "شاي بدون سكر");
                    dataset.setValue(sum_turkishcoffee, year, "قهوة تركية");
                    dataset.setValue(sum_coffee, year, "قهوة نسكافيه بدون سكر");
                } else if (combo_food.getSelectedIndex() == 8) {
                    select_type9("", "", "", year);
                    dataset.setValue(sum_appleJuice, year, "عصير تفاح طازج");
                    dataset.setValue(sum_orangeJuice, year, "عصير برتقال طازج");
                    dataset.setValue(sum_pineappleJuice, year, "عصير أناناس طازج");
                    dataset.setValue(sum_redGrabesJuice, year, "عصير عنب احمر طازج");
                    dataset.setValue(sum_pomegranateJuice, year, "عصير رمان طازج ");
                }

                JFreeChart chart = ChartFactory.createLineChart("Food Information in: " + year, "food type", "quantity", dataset, PlotOrientation.VERTICAL, false, true, true);
                BarRenderer renderer = null;
                CategoryPlot plot = null;
                renderer = new BarRenderer();
                ChartFrame frame = new ChartFrame("Line Chart", chart);
                frame.setVisible(true);
                frame.setSize(600, 500);

                if (rad_save.isSelected()) {
                    final ChartRenderingInfo info = new ChartRenderingInfo(new StandardEntityCollection());
                    final File file1 = new File("line chart for food quantites.png ");
                    ChartUtilities.saveChartAsPNG(file1, chart, 1200, 600, info);
                    JOptionPane.showMessageDialog(null, "تم حفظ الصورة بنجاح ");
                }
            } catch (Exception e) {
              //  JOptionPane.showMessageDialog(null, e);
            }

        } //ــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــ
        else if (select == 1 && search_month1.isSelected()) {
            // with month
            String month = combo_month2.getSelectedItem().toString();
            String year = month_year.getText();
            try {

                String sql = "select * from invoices where month='" + month + "' and year = '" + year + "'  ";

                DefaultCategoryDataset dataset = new DefaultCategoryDataset();
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();

                int i = 1;
                while (rs.next()) {
                    //String date = rs.getString("date");

                    dataset.setValue(Double.parseDouble(rs.getString("total")), month, rs.getString("date") + " (" + i + ")");
                    i++;
                }
                JFreeChart chart = ChartFactory.createLineChart("Profits Information in: " + month, "date", "total", dataset, PlotOrientation.VERTICAL, false, true, true);
                BarRenderer renderer = null;
                CategoryPlot plot = null;
                plot = chart.getCategoryPlot();

                renderer = new BarRenderer();
                ChartFrame frame = new ChartFrame("Line Chart", chart);
                frame.setVisible(true);
                frame.setSize(600, 500);

                if (rad_save.isSelected()) {
                    final ChartRenderingInfo info = new ChartRenderingInfo(new StandardEntityCollection());
                    final File file1 = new File("line chart for Profits.png ");
                    ChartUtilities.saveChartAsPNG(file1, chart, 1200, 600, info);
                    JOptionPane.showMessageDialog(null, "تم حفظ الصورة بنجاح ");
                }
            } catch (Exception e) {
               // JOptionPane.showMessageDialog(null, e);
            } finally {
                try {
                    pst.close();
                    rs.close();
                } catch (SQLException ex) {
                  //  Logger.getLogger(Management.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else if (select == 1 && search_year1.isSelected() && dayes.isSelected()) {
            String year = year_txt1.getText();
            //String month = combo_month2.getSelectedItem().toString();

            try {

                String sql = "select * from invoices where year='" + year + "' ";
                //JDBCCategoryDataset dataset = new JDBCCategoryDataset(con, sql);
                DefaultCategoryDataset dataset = new DefaultCategoryDataset();
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                int i = 1;
                while (rs.next()) {
                    // int i =0;
                    dataset.setValue(Double.parseDouble(rs.getString("total")), rs.getString("month"), rs.getString("date") + " (" + i + ")");
                    i++;
                }
                JFreeChart chart = ChartFactory.createLineChart("Profits Information in: " + year, "date", "total", dataset, PlotOrientation.VERTICAL, false, true, true);
                BarRenderer renderer = null;
                CategoryPlot plot = null;
                plot = chart.getCategoryPlot();

                renderer = new BarRenderer();
                ChartFrame frame = new ChartFrame("Line Chart", chart);
                frame.setVisible(true);
                frame.setSize(600, 500);

                if (rad_save.isSelected()) {
                    final ChartRenderingInfo info = new ChartRenderingInfo(new StandardEntityCollection());
                    final File file1 = new File("line chart for Profits.png ");
                    ChartUtilities.saveChartAsPNG(file1, chart, 1200, 600, info);
                    JOptionPane.showMessageDialog(null, "تم حفظ الصورة بنجاح ");
                }

            } catch (Exception e) {
               // JOptionPane.showMessageDialog(null, e);
            } finally {
                try {
                    pst.close();
                    rs.close();
                } catch (SQLException ex) {
                  //  Logger.getLogger(Management.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        } else if (select == 1 && search_year1.isSelected() && months.isSelected()) {
            try {
                String year = year_txt1.getText();
                select_month_total(year);

                DefaultCategoryDataset dataset = new DefaultCategoryDataset();

                dataset.setValue(total_1, year, "January");
                dataset.setValue(total_2, year, "Febraury");
                dataset.setValue(total_3, year, "March");
                dataset.setValue(total_4, year, "April");
                dataset.setValue(total_5, year, "May");
                dataset.setValue(total_6, year, "June");
                dataset.setValue(total_7, year, "July");
                dataset.setValue(total_8, year, "August");
                dataset.setValue(total_9, year, "September");
                dataset.setValue(total_10, year, "October");
                dataset.setValue(total_11, year, "November");
                dataset.setValue(total_12, year, "December");

                JFreeChart chart = ChartFactory.createLineChart("Profits Information in: " + year, "month", "total", dataset, PlotOrientation.VERTICAL, false, true, true);
                BarRenderer renderer = null;
                CategoryPlot plot = null;
                plot = chart.getCategoryPlot();

                renderer = new BarRenderer();
                ChartFrame frame = new ChartFrame("Line Chart", chart);
                frame.setVisible(true);
                frame.setSize(600, 500);

                if (rad_save.isSelected()) {
                    final ChartRenderingInfo info = new ChartRenderingInfo(new StandardEntityCollection());
                    final File file1 = new File("line chart for Profits.png ");
                    ChartUtilities.saveChartAsPNG(file1, chart, 1200, 600, info);
                    JOptionPane.showMessageDialog(null, "تم حفظ الصورة بنجاح ");
                }
            } catch (Exception e) {
             //   JOptionPane.showMessageDialog(null, e);
            }

        }

    }

    private void chart_pie() {

        int select = combo_chartType.getSelectedIndex();

        if (select == 0 && search_day1.isSelected()) {
            // with day
            try {

                DefaultPieDataset dataset = new DefaultPieDataset();

                int day1 = Integer.parseInt(day_now.getText());
                int month1 = Integer.parseInt(month_now.getText());
                int year1 = Integer.parseInt(year_now.getText());
                String date = "" + day1 + "/" + month1 + "/" + year1 + "";

                if (combo_food.getSelectedIndex() == 0) {
                    select_type1(date, "", "", "");
                    dataset.setValue("حمص", sum_hms);
                    dataset.setValue("ورق عنب ", sum_waragenab);
                    dataset.setValue("بابا غنوج", sum_babagnooj);
                    dataset.setValue("لبنة بالثوم", sum_labnahthoom);
                } else if (combo_food.getSelectedIndex() == 1) {
                    select_type2(date, "", "", "");
                    dataset.setValue("شوربة دجاج بالخضار", sum_shorbahdajajkudar);
                    dataset.setValue("شوربة مشروم", sum_shorbahmashroom);
                    dataset.setValue("شوربة خضار", sum_shorbahkudar);
                } else if (combo_food.getSelectedIndex() == 2) {
                    select_type3(date, "", "", "");
                    dataset.setValue("سلطة المعكرونة المشكلة ", sum_makaronahSaladM);
                    dataset.setValue("معكرونة سادة", sum_makaronah);
                } else if (combo_food.getSelectedIndex() == 3) {
                    select_type4(date, "", "", "");
                    dataset.setValue("سلطة الدجاج المشوي", sum_dajajSalad);
                    dataset.setValue("مرقوق دجاج ", sum_dajajMargoog);
                    dataset.setValue("مجبوس دجاج", sum_dajajMajboos);
                    dataset.setValue("مرق دجاج", sum_dajajMarag);
                } else if (combo_food.getSelectedIndex() == 4) {
                    select_type5(date, "", "", "");
                    dataset.setValue("مجبوس لحم", sum_majboosLaham);
                    dataset.setValue("برياني لحم", sum_bryaniLaham);
                    dataset.setValue("مرق لحم", sum_maragLaham);
                } else if (combo_food.getSelectedIndex() == 5) {
                    select_type6(date, "", "", "");
                    dataset.setValue("أرز ابيض", sum_whiteRice);
                    dataset.setValue("أرز بالشعيرية", sum_sheriaRice);
                    dataset.setValue("أرز بالعدس", sum_adasRice);
                } else if (combo_food.getSelectedIndex() == 6) {
                    select_type7(date, "", "", "");
                    dataset.setValue("فتوش", sum_fatoosh);
                    dataset.setValue("سلطة الملفوف", sum_malfoofSalad);
                    dataset.setValue("تبولة", sum_tabolah);
                    dataset.setValue("سلطة خضراء", sum_greenSalad);
                    dataset.setValue("سلطة التونة", sum_tunaSalad);
                    dataset.setValue("سلطة البطاطس", sum_PotatosSalad);
                    dataset.setValue("سلطة سيزر", sum_ceserSalad);
                    dataset.setValue("سلطة المعكرونة", sum_makaronahsSalad);
                } else if (combo_food.getSelectedIndex() == 7) {
                    select_type8(date, "", "", "");
                    dataset.setValue("مياه معدنية", sum_water);
                    dataset.setValue("شاي بدون سكر", sum_tea);
                    dataset.setValue("قهوة تركية", sum_turkishcoffee);
                    dataset.setValue("قهوة نسكافيه بدون سكر", sum_coffee);
                } else if (combo_food.getSelectedIndex() == 8) {
                    select_type9(date, "", "", "");
                    dataset.setValue("عصير تفاح طازج", sum_appleJuice);
                    dataset.setValue("عصير برتقال طازج", sum_orangeJuice);
                    dataset.setValue("عصير أناناس طازج", sum_pineappleJuice);
                    dataset.setValue("عصير عنب احمر طازج", sum_redGrabesJuice);
                    dataset.setValue("عصير رمان طازج ", sum_pomegranateJuice);
                }

                JFreeChart chart = ChartFactory.createPieChart("Food Information in: " + date, dataset, true, true, false);
                BarRenderer renderer = null;
                CategoryPlot plot = null;
                renderer = new BarRenderer();
                ChartFrame frame = new ChartFrame("Pie Chart", chart);
                frame.setVisible(true);
                frame.setSize(600, 500);

                if (rad_save.isSelected()) {
                    final ChartRenderingInfo info = new ChartRenderingInfo(new StandardEntityCollection());
                    final File file1 = new File("Pie chart for food quantites.png ");
                    ChartUtilities.saveChartAsPNG(file1, chart, 1200, 600, info);
                    JOptionPane.showMessageDialog(null, "تم حفظ الصورة بنجاح ");
                }
            } catch (Exception e) {
              //  JOptionPane.showMessageDialog(null, e);
            }
        } else if (select == 0 && search_month1.isSelected()) {
            // with month
            String month = combo_month2.getSelectedItem().toString();
            String year_month = month_year.getText();
            try {

                DefaultPieDataset dataset = new DefaultPieDataset();

                if (combo_food.getSelectedIndex() == 0) {
                    select_type1("", month, year_month, "");
                    dataset.setValue("حمص", sum_hms);
                    dataset.setValue("ورق عنب ", sum_waragenab);
                    dataset.setValue("بابا غنوج", sum_babagnooj);
                    dataset.setValue("لبنة بالثوم", sum_labnahthoom);
                } else if (combo_food.getSelectedIndex() == 1) {
                    select_type2("", month, year_month, "");
                    dataset.setValue("شوربة دجاج بالخضار", sum_shorbahdajajkudar);
                    dataset.setValue("شوربة مشروم", sum_shorbahmashroom);
                    dataset.setValue("شوربة خضار", sum_shorbahkudar);
                } else if (combo_food.getSelectedIndex() == 2) {
                    select_type3("", month, year_month, "");
                    dataset.setValue("سلطة المعكرونة المشكلة ", sum_makaronahSaladM);
                    dataset.setValue("معكرونة سادة", sum_makaronah);
                } else if (combo_food.getSelectedIndex() == 3) {
                    select_type4("", month, year_month, "");
                    dataset.setValue("سلطة الدجاج المشوي", sum_dajajSalad);
                    dataset.setValue("مرقوق دجاج ", sum_dajajMargoog);
                    dataset.setValue("مجبوس دجاج", sum_dajajMajboos);
                    dataset.setValue("مرق دجاج", sum_dajajMarag);
                } else if (combo_food.getSelectedIndex() == 4) {
                    select_type5("", month, year_month, "");
                    dataset.setValue("مجبوس لحم", sum_majboosLaham);
                    dataset.setValue("برياني لحم", sum_bryaniLaham);
                    dataset.setValue("مرق لحم", sum_maragLaham);
                } else if (combo_food.getSelectedIndex() == 5) {
                    select_type6("", month, year_month, "");
                    dataset.setValue("أرز ابيض", sum_whiteRice);
                    dataset.setValue("أرز بالشعيرية", sum_sheriaRice);
                    dataset.setValue("أرز بالعدس", sum_adasRice);
                } else if (combo_food.getSelectedIndex() == 6) {
                    select_type7("", month, year_month, "");
                    dataset.setValue("فتوش", sum_fatoosh);
                    dataset.setValue("سلطة الملفوف", sum_malfoofSalad);
                    dataset.setValue("تبولة", sum_tabolah);
                    dataset.setValue("سلطة خضراء", sum_greenSalad);
                    dataset.setValue("سلطة التونة", sum_tunaSalad);
                    dataset.setValue("سلطة البطاطس", sum_PotatosSalad);
                    dataset.setValue("سلطة سيزر", sum_ceserSalad);
                    dataset.setValue("سلطة المعكرونة", sum_makaronahsSalad);
                } else if (combo_food.getSelectedIndex() == 7) {
                    select_type8("", month, year_month, "");
                    dataset.setValue("مياه معدنية", sum_water);
                    dataset.setValue("شاي بدون سكر", sum_tea);
                    dataset.setValue("قهوة تركية", sum_turkishcoffee);
                    dataset.setValue("قهوة نسكافيه بدون سكر", sum_coffee);
                } else if (combo_food.getSelectedIndex() == 8) {
                    select_type9("", month, year_month, "");
                    dataset.setValue("عصير تفاح طازج", sum_appleJuice);
                    dataset.setValue("عصير برتقال طازج", sum_orangeJuice);
                    dataset.setValue("عصير أناناس طازج", sum_pineappleJuice);
                    dataset.setValue("عصير عنب احمر طازج", sum_redGrabesJuice);
                    dataset.setValue("عصير رمان طازج ", sum_pomegranateJuice);
                }

                JFreeChart chart = ChartFactory.createPieChart("Food Information in: " + month, dataset, true, true, false);
                BarRenderer renderer = null;
                CategoryPlot plot = null;
                renderer = new BarRenderer();
                ChartFrame frame = new ChartFrame("Pie Chart", chart);
                frame.setVisible(true);
                frame.setSize(600, 500);

                if (rad_save.isSelected()) {
                    final ChartRenderingInfo info = new ChartRenderingInfo(new StandardEntityCollection());
                    final File file1 = new File("Pie chart for food quantites.png ");
                    ChartUtilities.saveChartAsPNG(file1, chart, 1200, 600, info);
                    JOptionPane.showMessageDialog(null, "تم حفظ الصورة بنجاح ");
                }
            } catch (Exception e) {
               // JOptionPane.showMessageDialog(null, e);
            }
        } else if (select == 0 && search_year1.isSelected()) {
            // with year
            String year = year_txt1.getText();
            try {

                DefaultPieDataset dataset = new DefaultPieDataset();

                if (combo_food.getSelectedIndex() == 0) {
                    select_type1("", "", "", year);
                    dataset.setValue("حمص", sum_hms);
                    dataset.setValue("ورق عنب ", sum_waragenab);
                    dataset.setValue("بابا غنوج", sum_babagnooj);
                    dataset.setValue("لبنة بالثوم", sum_labnahthoom);
                } else if (combo_food.getSelectedIndex() == 1) {
                    select_type2("", "", "", year);
                    dataset.setValue("شوربة دجاج بالخضار", sum_shorbahdajajkudar);
                    dataset.setValue("شوربة مشروم", sum_shorbahmashroom);
                    dataset.setValue("شوربة خضار", sum_shorbahkudar);
                } else if (combo_food.getSelectedIndex() == 2) {
                    select_type3("", "", "", year);
                    dataset.setValue("سلطة المعكرونة المشكلة ", sum_makaronahSaladM);
                    dataset.setValue("معكرونة سادة", sum_makaronah);
                } else if (combo_food.getSelectedIndex() == 3) {
                    select_type4("", "", "", year);
                    dataset.setValue("سلطة الدجاج المشوي", sum_dajajSalad);
                    dataset.setValue("مرقوق دجاج ", sum_dajajMargoog);
                    dataset.setValue("مجبوس دجاج", sum_dajajMajboos);
                    dataset.setValue("مرق دجاج", sum_dajajMarag);
                } else if (combo_food.getSelectedIndex() == 4) {
                    select_type5("", "", "", year);
                    dataset.setValue("مجبوس لحم", sum_majboosLaham);
                    dataset.setValue("برياني لحم", sum_bryaniLaham);
                    dataset.setValue("مرق لحم", sum_maragLaham);
                } else if (combo_food.getSelectedIndex() == 5) {
                    select_type6("", "", "", year);
                    dataset.setValue("أرز ابيض", sum_whiteRice);
                    dataset.setValue("أرز بالشعيرية", sum_sheriaRice);
                    dataset.setValue("أرز بالعدس", sum_adasRice);
                } else if (combo_food.getSelectedIndex() == 6) {
                    select_type7("", "", "", year);
                    dataset.setValue("فتوش", sum_fatoosh);
                    dataset.setValue("سلطة الملفوف", sum_malfoofSalad);
                    dataset.setValue("تبولة", sum_tabolah);
                    dataset.setValue("سلطة خضراء", sum_greenSalad);
                    dataset.setValue("سلطة التونة", sum_tunaSalad);
                    dataset.setValue("سلطة البطاطس", sum_PotatosSalad);
                    dataset.setValue("سلطة سيزر", sum_ceserSalad);
                    dataset.setValue("سلطة المعكرونة", sum_makaronahsSalad);
                } else if (combo_food.getSelectedIndex() == 7) {
                    select_type8("", "", "", year);
                    dataset.setValue("مياه معدنية", sum_water);
                    dataset.setValue("شاي بدون سكر", sum_tea);
                    dataset.setValue("قهوة تركية", sum_turkishcoffee);
                    dataset.setValue("قهوة نسكافيه بدون سكر", sum_coffee);
                } else if (combo_food.getSelectedIndex() == 8) {
                    select_type9("", "", "", year);
                    dataset.setValue("عصير تفاح طازج", sum_appleJuice);
                    dataset.setValue("عصير برتقال طازج", sum_orangeJuice);
                    dataset.setValue("عصير أناناس طازج", sum_pineappleJuice);
                    dataset.setValue("عصير عنب احمر طازج", sum_redGrabesJuice);
                    dataset.setValue("عصير رمان طازج ", sum_pomegranateJuice);
                }

                JFreeChart chart = ChartFactory.createPieChart("Food Information in: " + year, dataset, true, true, false);
                BarRenderer renderer = null;
                CategoryPlot plot = null;
                renderer = new BarRenderer();
                ChartFrame frame = new ChartFrame("Pie Chart", chart);
                frame.setVisible(true);
                frame.setSize(600, 500);

                if (rad_save.isSelected()) {
                    final ChartRenderingInfo info = new ChartRenderingInfo(new StandardEntityCollection());
                    final File file1 = new File("Pie chart for food quantites.png ");
                    ChartUtilities.saveChartAsPNG(file1, chart, 1200, 600, info);
                    JOptionPane.showMessageDialog(null, "تم حفظ الصورة بنجاح ");
                }

            } catch (Exception e) {
              //  JOptionPane.showMessageDialog(null, e);
            }
        } //____________________________________________________________________________________________
        else if (select == 1 && search_month1.isSelected()) {
            String month = combo_month2.getSelectedItem().toString();
            String year_month = month_year.getText();
            try {
                String sql = "select date , total from invoices where month = '" + month + "' and year = '" + year_month + "' ";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                DefaultPieDataset dataset = new DefaultPieDataset();
                int i = 1;
                while (rs.next()) {
                    dataset.setValue(rs.getString("date") + " (" + i + ")", rs.getDouble("total"));
                    i++;
                }
                JFreeChart chart = ChartFactory.createPieChart("Profits Information in: " + month, dataset, false, true, true);

                ChartFrame frame = new ChartFrame("Pie Chart", chart);
                frame.setVisible(true);
                frame.setSize(600, 500);

                if (rad_save.isSelected()) {
                    final ChartRenderingInfo info = new ChartRenderingInfo(new StandardEntityCollection());
                    final File file1 = new File("Pie chart for Profits.png ");
                    ChartUtilities.saveChartAsPNG(file1, chart, 1200, 600, info);
                    JOptionPane.showMessageDialog(null, "تم حفظ الصورة بنجاح ");
                }

            } catch (Exception e) {
              //  JOptionPane.showMessageDialog(null, e);
            } finally {
                try {
                    pst.close();
                    rs.close();
                } catch (SQLException ex) {
                   // Logger.getLogger(Management.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        } else if (select == 1 && search_year1.isSelected() && dayes.isSelected()) {
            String year = year_txt1.getText();
            try {
                String sql = "select date , total from invoices where year = '" + year + "' ";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                DefaultPieDataset dataset = new DefaultPieDataset();
                int i = 1;
                while (rs.next()) {
                    dataset.setValue(rs.getString("date") + " (" + i + ")", rs.getDouble("total"));
                    i++;
                }
                JFreeChart chart = ChartFactory.createPieChart("Profits Information in: " + year, dataset, false, true, true);

                ChartFrame frame = new ChartFrame("Pie Chart", chart);
                frame.setVisible(true);
                frame.setSize(600, 500);
                if (rad_save.isSelected()) {
                    final ChartRenderingInfo info = new ChartRenderingInfo(new StandardEntityCollection());
                    final File file1 = new File("Pie chart for Profits.png ");
                    ChartUtilities.saveChartAsPNG(file1, chart, 1200, 600, info);
                    JOptionPane.showMessageDialog(null, "تم حفظ الصورة بنجاح ");
                }

            } catch (Exception e) {
              //  JOptionPane.showMessageDialog(null, e);
            } finally {
                try {
                    pst.close();
                    rs.close();
                } catch (SQLException ex) {
                   // Logger.getLogger(Management.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        } else if (select == 1 && search_year1.isSelected() && months.isSelected()) {
            String year = year_txt1.getText();
            try {
                select_month_total(year);

                DefaultPieDataset dataset = new DefaultPieDataset();

                dataset.setValue("January", total_1);
                dataset.setValue("Febraury", total_2);
                dataset.setValue("March", total_3);
                dataset.setValue("April", total_4);
                dataset.setValue("May", total_5);
                dataset.setValue("June", total_6);
                dataset.setValue("July", total_7);
                dataset.setValue("August", total_8);
                dataset.setValue("September", total_9);
                dataset.setValue("October", total_10);
                dataset.setValue("November", total_11);
                dataset.setValue("December", total_12);

                JFreeChart chart = ChartFactory.createPieChart("Profits Information in: " + year, dataset, false, true, true);

                ChartFrame frame = new ChartFrame("Pie Chart", chart);
                frame.setVisible(true);
                frame.setSize(600, 500);

                if (rad_save.isSelected()){
                    final ChartRenderingInfo info = new ChartRenderingInfo(new StandardEntityCollection());
                    final File file1 = new File("Pie chart for Profits.png ");
                    ChartUtilities.saveChartAsPNG(file1, chart, 1200, 600, info);
                    JOptionPane.showMessageDialog(null, "تم حفظ الصورة بنجاح ");
                }

            } catch (Exception e) {
              //  JOptionPane.showMessageDialog(null, e);
            }

        }
    }

    private void chart_bar() {

        int select = combo_chartType.getSelectedIndex();

        if (select == 0 && search_day1.isSelected()) {
            // with day
            int day1 = Integer.parseInt(day_now.getText());
            int month1 = Integer.parseInt(month_now.getText());
            int year1 = Integer.parseInt(year_now.getText());
            String date = "" + day1 + "/" + month1 + "/" + year1 + "";
            try {

                DefaultCategoryDataset dataset = new DefaultCategoryDataset();

                if (combo_food.getSelectedIndex() == 0) {
                    select_type1(date, "", "", "");
                    dataset.setValue(sum_hms, date, "حمص");
                    dataset.setValue(sum_waragenab, date, "ورق عنب ");
                    dataset.setValue(sum_babagnooj, date, "بابا غنوج");
                    dataset.setValue(sum_labnahthoom, date, "لبنة بالثوم");
                } else if (combo_food.getSelectedIndex() == 1) {
                    select_type2(date, "", "", "");
                    dataset.setValue(sum_shorbahdajajkudar, date, "شوربة دجاج بالخضار");
                    dataset.setValue(sum_shorbahmashroom, date, "شوربة مشروم");
                    dataset.setValue(sum_shorbahkudar, date, "شوربة خضار");
                } else if (combo_food.getSelectedIndex() == 2) {
                    select_type3(date, "", "", "");
                    dataset.setValue(sum_makaronahSaladM, date, "سلطة المعكرونة المشكلة ");
                    dataset.setValue(sum_makaronah, date, "معكرونة سادة");
                } else if (combo_food.getSelectedIndex() == 3) {
                    select_type4(date, "", "", "");
                    dataset.setValue(sum_dajajSalad, date, "سلطة الدجاج المشوي");
                    dataset.setValue(sum_dajajMargoog, date, "مرقوق دجاج ");
                    dataset.setValue(sum_dajajMajboos, date, "مجبوس دجاج");
                    dataset.setValue(sum_dajajMarag, date, "مرق دجاج");
                } else if (combo_food.getSelectedIndex() == 4) {
                    select_type5(date, "", "", "");
                    dataset.setValue(sum_majboosLaham, date, "مجبوس لحم");
                    dataset.setValue(sum_bryaniLaham, date, "برياني لحم");
                    dataset.setValue(sum_maragLaham, date, "مرق لحم");
                } else if (combo_food.getSelectedIndex() == 5) {
                    select_type6(date, "", "", "");
                    dataset.setValue(sum_whiteRice, date, "أرز ابيض");
                    dataset.setValue(sum_sheriaRice, date, "أرز بالشعيرية");
                    dataset.setValue(sum_adasRice, date, "أرز بالعدس");
                } else if (combo_food.getSelectedIndex() == 6) {
                    select_type7(date, "", "", "");
                    dataset.setValue(sum_fatoosh, date, "فتوش");
                    dataset.setValue(sum_malfoofSalad, date, "سلطة الملفوف");
                    dataset.setValue(sum_tabolah, date, "تبولة");
                    dataset.setValue(sum_greenSalad, date, "سلطة خضراء");
                    dataset.setValue(sum_tunaSalad, date, "سلطة التونة");
                    dataset.setValue(sum_PotatosSalad, date, "سلطة البطاطس");
                    dataset.setValue(sum_ceserSalad, date, "سلطة سيزر");
                    dataset.setValue(sum_makaronahsSalad, date, "سلطة المعكرونة");
                } else if (combo_food.getSelectedIndex() == 7) {
                    select_type8(date, "", "", "");
                    dataset.setValue(sum_water, date, "مياه معدنية");
                    dataset.setValue(sum_tea, date, "شاي بدون سكر");
                    dataset.setValue(sum_turkishcoffee, date, "قهوة تركية");
                    dataset.setValue(sum_coffee, date, "قهوة نسكافيه بدون سكر");
                } else if (combo_food.getSelectedIndex() == 8) {
                    select_type9(date, "", "", "");
                    dataset.setValue(sum_appleJuice, date, "عصير تفاح طازج");
                    dataset.setValue(sum_orangeJuice, date, "عصير برتقال طازج");
                    dataset.setValue(sum_pineappleJuice, date, "عصير أناناس طازج");
                    dataset.setValue(sum_redGrabesJuice, date, "عصير عنب احمر طازج");
                    dataset.setValue(sum_pomegranateJuice, date, "عصير رمان طازج ");
                }

                JFreeChart chart = ChartFactory.createBarChart("Food Information in: " + date, "food type", "quantity", dataset, PlotOrientation.VERTICAL, false, true, true);
                BarRenderer renderer = null;
                CategoryPlot plot = null;
                renderer = new BarRenderer();
                ChartFrame frame = new ChartFrame("Bar Chart", chart);
                frame.setVisible(true);
                frame.setSize(600, 500);

                if (rad_save.isSelected()) {
                    final ChartRenderingInfo info = new ChartRenderingInfo(new StandardEntityCollection());
                    final File file1 = new File("Bar chart for food quantites.png ");
                    ChartUtilities.saveChartAsPNG(file1, chart, 1200, 600, info);
                    JOptionPane.showMessageDialog(null, "تم حفظ الصورة بنجاح ");
                }
            } catch (Exception e) {
               // JOptionPane.showMessageDialog(null, e);
            }
        } else if (select == 0 && search_month1.isSelected()) {
            // with month
            String month = combo_month2.getSelectedItem().toString();
            String year_month = month_year.getText();

            try {
                DefaultCategoryDataset dataset = new DefaultCategoryDataset();

                if (combo_food.getSelectedIndex() == 0) {
                    select_type1("", month, year_month, "");
                    dataset.setValue(sum_hms, month, "حمص");
                    dataset.setValue(sum_waragenab, month, "ورق عنب ");
                    dataset.setValue(sum_babagnooj, month, "بابا غنوج");
                    dataset.setValue(sum_labnahthoom, month, "لبنة بالثوم");
                } else if (combo_food.getSelectedIndex() == 1) {
                    select_type2("", month, year_month, "");
                    dataset.setValue(sum_shorbahdajajkudar, month, "شوربة دجاج بالخضار");
                    dataset.setValue(sum_shorbahmashroom, month, "شوربة مشروم");
                    dataset.setValue(sum_shorbahkudar, month, "شوربة خضار");
                } else if (combo_food.getSelectedIndex() == 2) {
                    select_type3("", month, year_month, "");
                    dataset.setValue(sum_makaronahSaladM, month, "سلطة المعكرونة المشكلة ");
                    dataset.setValue(sum_makaronah, month, "معكرونة سادة");
                } else if (combo_food.getSelectedIndex() == 3) {
                    select_type4("", month, year_month, "");
                    dataset.setValue(sum_dajajSalad, month, "سلطة الدجاج المشوي");
                    dataset.setValue(sum_dajajMargoog, month, "مرقوق دجاج ");
                    dataset.setValue(sum_dajajMajboos, month, "مجبوس دجاج");
                    dataset.setValue(sum_dajajMarag, month, "مرق دجاج");
                } else if (combo_food.getSelectedIndex() == 4) {
                    select_type5("", month, year_month, "");
                    dataset.setValue(sum_majboosLaham, month, "مجبوس لحم");
                    dataset.setValue(sum_bryaniLaham, month, "برياني لحم");
                    dataset.setValue(sum_maragLaham, month, "مرق لحم");
                } else if (combo_food.getSelectedIndex() == 5) {
                    select_type6("", month, year_month, "");
                    dataset.setValue(sum_whiteRice, month, "أرز ابيض");
                    dataset.setValue(sum_sheriaRice, month, "أرز بالشعيرية");
                    dataset.setValue(sum_adasRice, month, "أرز بالعدس");
                } else if (combo_food.getSelectedIndex() == 6) {
                    select_type7("", month, year_month, "");

                    dataset.setValue(sum_fatoosh, month, "فتوش");
                    dataset.setValue(sum_malfoofSalad, month, "سلطة الملفوف");
                    dataset.setValue(sum_tabolah, month, "تبولة");
                    dataset.setValue(sum_greenSalad, month, "سلطة خضراء");
                    dataset.setValue(sum_tunaSalad, month, "سلطة التونة");
                    dataset.setValue(sum_PotatosSalad, month, "سلطة البطاطس");
                    dataset.setValue(sum_ceserSalad, month, "سلطة سيزر");
                    dataset.setValue(sum_makaronahsSalad, month, "سلطة المعكرونة");
                } else if (combo_food.getSelectedIndex() == 7) {
                    select_type8("", month, year_month, "");
                    dataset.setValue(sum_water, month, "مياه معدنية");
                    dataset.setValue(sum_tea, month, "شاي بدون سكر");
                    dataset.setValue(sum_turkishcoffee, month, "قهوة تركية");
                    dataset.setValue(sum_coffee, month, "قهوة نسكافيه بدون سكر");
                } else if (combo_food.getSelectedIndex() == 8) {
                    select_type9("", month, year_month, "");
                    dataset.setValue(sum_appleJuice, month, "عصير تفاح طازج");
                    dataset.setValue(sum_orangeJuice, month, "عصير برتقال طازج");
                    dataset.setValue(sum_pineappleJuice, month, "عصير أناناس طازج");
                    dataset.setValue(sum_redGrabesJuice, month, "عصير عنب احمر طازج");
                    dataset.setValue(sum_pomegranateJuice, month, "عصير رمان طازج ");
                }

                JFreeChart chart = ChartFactory.createBarChart("Food Information in: " + month, "food type", "quantity", dataset, PlotOrientation.VERTICAL, false, true, true);
                BarRenderer renderer = null;
                CategoryPlot plot = null;
                renderer = new BarRenderer();
                ChartFrame frame = new ChartFrame("Bar Chart", chart);
                frame.setVisible(true);
                frame.setSize(600, 500);

                if (rad_save.isSelected()) {
                    final ChartRenderingInfo info = new ChartRenderingInfo(new StandardEntityCollection());
                    final File file1 = new File("Bar chart for food quantites.png ");
                    ChartUtilities.saveChartAsPNG(file1, chart, 1200, 600, info);
                    JOptionPane.showMessageDialog(null, "تم حفظ الصورة بنجاح ");
                }

            } catch (Exception e) {
               // JOptionPane.showMessageDialog(null, e);
            }
        } else if (select == 0 && search_year1.isSelected()) {
            // with year
            String year = year_txt1.getText();
            try {
                DefaultCategoryDataset dataset = new DefaultCategoryDataset();

                if (combo_food.getSelectedIndex() == 0) {
                    select_type1("", "", "", year);
                    dataset.setValue(sum_hms, year, "حمص");
                    dataset.setValue(sum_waragenab, year, "ورق عنب ");
                    dataset.setValue(sum_babagnooj, year, "بابا غنوج");
                    dataset.setValue(sum_labnahthoom, year, "لبنة بالثوم");
                } else if (combo_food.getSelectedIndex() == 1) {
                    select_type2("", "", "", year);
                    dataset.setValue(sum_shorbahdajajkudar, year, "شوربة دجاج بالخضار");
                    dataset.setValue(sum_shorbahmashroom, year, "شوربة مشروم");
                    dataset.setValue(sum_shorbahkudar, year, "شوربة خضار");
                } else if (combo_food.getSelectedIndex() == 2) {
                    select_type3("", "", "", year);
                    dataset.setValue(sum_makaronahSaladM, year, "سلطة المعكرونة المشكلة ");
                    dataset.setValue(sum_makaronah, year, "معكرونة سادة");
                } else if (combo_food.getSelectedIndex() == 3) {
                    select_type4("", "", "", year);
                    dataset.setValue(sum_dajajSalad, year, "سلطة الدجاج المشوي");
                    dataset.setValue(sum_dajajMargoog, year, "مرقوق دجاج ");
                    dataset.setValue(sum_dajajMajboos, year, "مجبوس دجاج");
                    dataset.setValue(sum_dajajMarag, year, "مرق دجاج");
                } else if (combo_food.getSelectedIndex() == 4) {
                    select_type5("", "", "", year);
                    dataset.setValue(sum_majboosLaham, year, "مجبوس لحم");
                    dataset.setValue(sum_bryaniLaham, year, "برياني لحم");
                    dataset.setValue(sum_maragLaham, year, "مرق لحم");
                } else if (combo_food.getSelectedIndex() == 5) {
                    select_type6("", "", "", year);
                    dataset.setValue(sum_whiteRice, year, "أرز ابيض");
                    dataset.setValue(sum_sheriaRice, year, "أرز بالشعيرية");
                    dataset.setValue(sum_adasRice, year, "أرز بالعدس");
                } else if (combo_food.getSelectedIndex() == 6) {
                    select_type7("", "", "", year);
                    dataset.setValue(sum_fatoosh, year, "فتوش");
                    dataset.setValue(sum_malfoofSalad, year, "سلطة الملفوف");
                    dataset.setValue(sum_tabolah, year, "تبولة");
                    dataset.setValue(sum_greenSalad, year, "سلطة خضراء");
                    dataset.setValue(sum_tunaSalad, year, "سلطة التونة");
                    dataset.setValue(sum_PotatosSalad, year, "سلطة البطاطس");
                    dataset.setValue(sum_ceserSalad, year, "سلطة سيزر");
                    dataset.setValue(sum_makaronahsSalad, year, "سلطة المعكرونة");
                } else if (combo_food.getSelectedIndex() == 7) {
                    select_type8("", "", "", year);
                    dataset.setValue(sum_water, year, "مياه معدنية");
                    dataset.setValue(sum_tea, year, "شاي بدون سكر");
                    dataset.setValue(sum_turkishcoffee, year, "قهوة تركية");
                    dataset.setValue(sum_coffee, year, "قهوة نسكافيه بدون سكر");
                } else if (combo_food.getSelectedIndex() == 8) {
                    select_type9("", "", "", year);
                    dataset.setValue(sum_appleJuice, year, "عصير تفاح طازج");
                    dataset.setValue(sum_orangeJuice, year, "عصير برتقال طازج");
                    dataset.setValue(sum_pineappleJuice, year, "عصير أناناس طازج");
                    dataset.setValue(sum_redGrabesJuice, year, "عصير عنب احمر طازج");
                    dataset.setValue(sum_pomegranateJuice, year, "عصير رمان طازج ");
                }

                JFreeChart chart = ChartFactory.createBarChart("Food Information in: " + year, "food type", "quantity", dataset, PlotOrientation.VERTICAL, false, true, true);
                BarRenderer renderer = null;
                CategoryPlot plot = null;
                renderer = new BarRenderer();
                ChartFrame frame = new ChartFrame("Bar Chart", chart);
                frame.setVisible(true);
                frame.setSize(600, 500);

                if (rad_save.isSelected()) {
                    final ChartRenderingInfo info = new ChartRenderingInfo(new StandardEntityCollection());
                    final File file1 = new File("Bar chart for food quantites.png ");
                    ChartUtilities.saveChartAsPNG(file1, chart, 1200, 600, info);
                    JOptionPane.showMessageDialog(null, "تم حفظ الصورة بنجاح ");
                }

            } catch (Exception e) {
               // JOptionPane.showMessageDialog(null, e);
            }
            //________________________________________________________________________________________________________________

        } else if (select == 1 && search_month1.isSelected()) {
            // with month
            String month = combo_month2.getSelectedItem().toString();
            String year_month = month_year.getText();
            try {

                String sql = "select * from invoices where month='" + month + "' and year = '" + year_month + "' ";

                DefaultCategoryDataset dataset = new DefaultCategoryDataset();
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                int i = 1;
                while (rs.next()) {
                    // int i =0;
                    dataset.setValue(Double.parseDouble(rs.getString("total")), month, rs.getString("date") + " (" + i + ")");
                    i++;
                }
                JFreeChart chart = ChartFactory.createBarChart("Profits Information in: " + month, "date", "total", dataset, PlotOrientation.VERTICAL, false, true, true);
                BarRenderer renderer = null;
                CategoryPlot plot = null;
                plot = chart.getCategoryPlot();

                renderer = new BarRenderer();
                ChartFrame frame = new ChartFrame("Bar Chart", chart);
                frame.setVisible(true);
                frame.setSize(600, 500);

                if (rad_save.isSelected()) {
                    final ChartRenderingInfo info = new ChartRenderingInfo(new StandardEntityCollection());
                    final File file1 = new File("Bar chart for Profits.png ");
                    ChartUtilities.saveChartAsPNG(file1, chart, 1200, 600, info);
                    JOptionPane.showMessageDialog(null, "تم حفظ الصورة بنجاح ");
                }

            } catch (Exception e) {
                //JOptionPane.showMessageDialog(null, e);
            } finally {
                try {
                    pst.close();
                    rs.close();
                } catch (SQLException ex) {
                  //  Logger.getLogger(Management.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else if (select == 1 && search_year1.isSelected() && dayes.isSelected()) {
            // with year and day
            String year = year_txt1.getText();
            try {

                String sql = "select date , total from invoices where year='" + year + "' ";
                DefaultCategoryDataset dataset = new DefaultCategoryDataset();
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                int i = 1;
                while (rs.next()) {
                    // int i =0;
                    dataset.setValue(Double.parseDouble(rs.getString("total")), year, rs.getString("date") + " (" + i + ")");
                    i++;
                }
                JFreeChart chart = ChartFactory.createBarChart("Profits Information in: " + year, "date", "total", dataset, PlotOrientation.VERTICAL, false, true, true);
                BarRenderer renderer = null;
                CategoryPlot plot = null;
                plot = chart.getCategoryPlot();

                renderer = new BarRenderer();
                ChartFrame frame = new ChartFrame("Bar Chart", chart);
                frame.setVisible(true);
                frame.setSize(600, 500);

                if (rad_save.isSelected()) {
                    final ChartRenderingInfo info = new ChartRenderingInfo(new StandardEntityCollection());
                    final File file1 = new File("Bar chart for Profits.png ");
                    ChartUtilities.saveChartAsPNG(file1, chart, 1200, 600, info);
                    JOptionPane.showMessageDialog(null, "تم حفظ الصورة بنجاح ");
                }

            } catch (Exception e) {
              //  JOptionPane.showMessageDialog(null, e);
            } finally {
                try {
                    pst.close();
                    rs.close();
                } catch (SQLException ex) {
                  //  Logger.getLogger(Management.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        } else if (select == 1 && search_year1.isSelected() && months.isSelected()) {
            // year with month
            String year = year_txt1.getText();
            try {
                select_month_total(year);

                DefaultCategoryDataset dataset = new DefaultCategoryDataset();
                dataset.setValue(total_1, year, "January");
                dataset.setValue(total_2, year, "Febraury");
                dataset.setValue(total_3, year, "March");
                dataset.setValue(total_4, year, "April");
                dataset.setValue(total_5, year, "May");
                dataset.setValue(total_6, year, "June");
                dataset.setValue(total_7, year, "July");
                dataset.setValue(total_8, year, "August");
                dataset.setValue(total_9, year, "September");
                dataset.setValue(total_10, year, "October");
                dataset.setValue(total_11, year, "November");
                dataset.setValue(total_12, year, "December");

                JFreeChart chart = ChartFactory.createBarChart("Profits Information in: " + year, "month", "total", dataset, PlotOrientation.VERTICAL, false, true, true);
                BarRenderer renderer = null;
                CategoryPlot plot = null;
                plot = chart.getCategoryPlot();

                renderer = new BarRenderer();
                ChartFrame frame = new ChartFrame("Bar Chart", chart);
                frame.setVisible(true);
                frame.setSize(600, 500);

                if (rad_save.isSelected()) {
                    final ChartRenderingInfo info = new ChartRenderingInfo(new StandardEntityCollection());
                    final File file1 = new File("Bar chart for Profits.png ");
                    ChartUtilities.saveChartAsPNG(file1, chart, 1200, 600, info);
                    JOptionPane.showMessageDialog(null, "تم حفظ الصورة بنجاح ");
                }

            } catch (Exception e) {
               // JOptionPane.showMessageDialog(null, e);
            }

        }

    }

    private void update_table() {
        try {
            String sql = "select employee_id as 'رقم الموظف' , civilRegistry as 'السجل المدني' ,fname as 'الآسم الاول' , lname as 'الآسم الثاني', age as 'العمر' , email as 'البريد الألكتروني' , mobileNum as 'رقم الجوال' ,telephoneNum as 'رق الهاتف' , gender as 'الجنس' , date as 'تآريخ الميلاد' , socialStatus as 'الحالة الأجتماعية' , nationality as 'الجنسية' , address as 'العنوان' , qualification as 'الدرجة العلمية' , DICE as 'درجة إجادة آستخدام الحاسوب ' from employeeInfo";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();

            table_employee.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            try {
                pst.close();
                rs.close();

            } catch (SQLException ex) {
                Logger.getLogger(Management.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void update_table1() {
        try {
            String sql = "select employee_id as 'رقم الموظف' , name as 'آسم الموظف' , login_time as 'وقت الدخول' , logout_time  as 'وقت الخروج' ,day as 'اليوم' ,month as 'الشهر' ,year as 'السنة' , date as 'التاريخ' from employeeWork";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();

            table_employee.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            try {
                pst.close();
                rs.close();

            } catch (SQLException ex) {
                Logger.getLogger(Management.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void update_table2() {
        try {
            String sql = "select invoice_id as 'رقم الموظف' , employee_name as 'آسم الموظف' , total as 'آجمالي السعر' , day as 'اليوم' , month as 'الشهر' ,year as 'السنة', date as 'التاريخ', time as  'الوقت' from invoices";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();

            table_invoice.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            try {
                pst.close();
                rs.close();

            } catch (SQLException ex) {
                Logger.getLogger(Management.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void update_table3() {
        try {
            String sql = "select fname as 'الآسم الاول' , lname as 'الاسم الثاني' , email as 'البريد الالكتروني' , phoneNum as 'رقم الجوال' , password as 'كلمة المرور' ,"
                    + "gender as 'الجنس ' , calories as 'السعرات الحرارية' , date as 'تاريخ الميلاد' , age as 'العمر', day as 'اليوم' , month as 'الشهر' , "
                    + "year as 'السنة' , datee as 'التاريخ' , time as 'الوقت' from userInfo";

            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            user_table.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            try {
                pst.close();
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(Management.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public void fillList() {
        DefaultListModel model = new DefaultListModel();
        try {
            String sql = "select * from employeeInfo";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                String name1 = rs.getString("fname");
                // String name2 = rs.getString("lname");
                //String fullName = name1 +" "+ name2;
                model.addElement(name1);
            }
            jList1.setModel(model);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            try {
                pst.close();
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(Management.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    private void currentDate() {

        Thread thread = new Thread() {
            public void run() {

                for (;;) {

                    Calendar cal = new GregorianCalendar();
                    int year = cal.get(Calendar.YEAR);
                    int month = cal.get(Calendar.MONTH);
                    int day = cal.get(Calendar.DAY_OF_MONTH);
                    label_date.setText(day + "/" + (month + 1) + "/" + year);
                    int hour = cal.get(Calendar.HOUR);
                    int minute = cal.get(Calendar.MINUTE);
                    int second = cal.get(Calendar.SECOND);

                    label_time.setText(hour + ":" + minute + ":" + second);
                    try {
                        sleep(1000);

                    } catch (InterruptedException ex) {
                        Logger.getLogger(Management.class
                                .getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        };
        thread.start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel12 = new javax.swing.JPanel();
        jLabel111 = new javax.swing.JLabel();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel4 = new javax.swing.JPanel();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        buttonGroup5 = new javax.swing.ButtonGroup();
        buttonGroup6 = new javax.swing.ButtonGroup();
        buttonGroup7 = new javax.swing.ButtonGroup();
        buttonGroup8 = new javax.swing.ButtonGroup();
        buttonGroup9 = new javax.swing.ButtonGroup();
        buttonGroup10 = new javax.swing.ButtonGroup();
        buttonGroup11 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jPanel13 = new javax.swing.JPanel();
        jLabel112 = new javax.swing.JLabel();
        label_time = new javax.swing.JLabel();
        label_date = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_employee = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        combo_order = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        EI_txt = new javax.swing.JTextField();
        fname_txt = new javax.swing.JTextField();
        nationality_txt = new javax.swing.JTextField();
        combo_age = new javax.swing.JComboBox<>();
        email_txt = new javax.swing.JTextField();
        mobileNum_txt = new javax.swing.JTextField();
        CR_txt = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        telephoneNum_txt = new javax.swing.JTextField();
        radioButton_male = new javax.swing.JRadioButton();
        radioButton_female = new javax.swing.JRadioButton();
        date_chooser = new com.toedter.calendar.JDateChooser();
        combo_sotial = new javax.swing.JComboBox<>();
        lname_txt1 = new javax.swing.JTextField();
        address_txt = new javax.swing.JTextField();
        checkBox_1 = new javax.swing.JCheckBox();
        checkBox_2 = new javax.swing.JCheckBox();
        checkBox_3 = new javax.swing.JCheckBox();
        checkBox_4 = new javax.swing.JCheckBox();
        combo_qualification = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jLabel22 = new javax.swing.JLabel();
        panel_search = new javax.swing.JPanel();
        combo_month = new javax.swing.JComboBox<>();
        year_txt = new javax.swing.JTextField();
        search_month = new javax.swing.JCheckBox();
        jButton10 = new javax.swing.JButton();
        search_year = new javax.swing.JCheckBox();
        s_year = new javax.swing.JTextField();
        s_month = new javax.swing.JTextField();
        s_day = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        search_date = new javax.swing.JCheckBox();
        year_txt3 = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jCheckBox9 = new javax.swing.JCheckBox();
        jButton3 = new javax.swing.JButton();
        search_txt = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        user_table = new javax.swing.JTable();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        fanme_txt = new javax.swing.JTextField();
        lname_txt = new javax.swing.JTextField();
        mail_txt = new javax.swing.JTextField();
        phone_txt = new javax.swing.JTextField();
        pass_txt = new javax.swing.JTextField();
        age_txt = new javax.swing.JTextField();
        cal_txt = new javax.swing.JTextField();
        date_choser = new com.toedter.calendar.JDateChooser();
        jLabel59 = new javax.swing.JLabel();
        rad_male = new javax.swing.JRadioButton();
        rad_female = new javax.swing.JRadioButton();
        jLabel60 = new javax.swing.JLabel();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        panel_search1 = new javax.swing.JPanel();
        combo_month3 = new javax.swing.JComboBox<>();
        year_txt2 = new javax.swing.JTextField();
        search_month2 = new javax.swing.JCheckBox();
        jButton20 = new javax.swing.JButton();
        jLabel61 = new javax.swing.JLabel();
        search_year2 = new javax.swing.JCheckBox();
        s_year1 = new javax.swing.JTextField();
        s_month1 = new javax.swing.JTextField();
        s_day1 = new javax.swing.JTextField();
        jLabel65 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        search_date1 = new javax.swing.JCheckBox();
        s_year2 = new javax.swing.JTextField();
        jCheckBox7 = new javax.swing.JCheckBox();
        search_txt1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_invoice = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        select_year = new javax.swing.JCheckBox();
        txt_year1 = new javax.swing.JTextField();
        select_day = new javax.swing.JCheckBox();
        jLabel4 = new javax.swing.JLabel();
        combo_month1 = new javax.swing.JComboBox<>();
        select_month = new javax.swing.JCheckBox();
        day_now2 = new javax.swing.JTextField();
        jLabel94 = new javax.swing.JLabel();
        month_now2 = new javax.swing.JTextField();
        jLabel95 = new javax.swing.JLabel();
        year_now4 = new javax.swing.JTextField();
        year_now5 = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        line_chart = new javax.swing.JCheckBox();
        bar_chart = new javax.swing.JCheckBox();
        pie_chart = new javax.swing.JCheckBox();
        combo_foodTime = new javax.swing.JPanel();
        combo_month2 = new javax.swing.JComboBox<>();
        year_txt1 = new javax.swing.JTextField();
        search_month1 = new javax.swing.JCheckBox();
        search_day1 = new javax.swing.JCheckBox();
        search_year1 = new javax.swing.JCheckBox();
        jPanel_time = new javax.swing.JPanel();
        months = new javax.swing.JCheckBox();
        dayes = new javax.swing.JCheckBox();
        day_now = new javax.swing.JTextField();
        month_now = new javax.swing.JTextField();
        year_now = new javax.swing.JTextField();
        jLabel87 = new javax.swing.JLabel();
        jLabel88 = new javax.swing.JLabel();
        month_year = new javax.swing.JTextField();
        combo_chartType = new javax.swing.JComboBox<>();
        combo_food = new javax.swing.JComboBox<>();
        rad_save = new javax.swing.JRadioButton();
        jButton22 = new javax.swing.JButton();
        jLabel79 = new javax.swing.JLabel();
        id_txt = new javax.swing.JTextField();
        jLabel80 = new javax.swing.JLabel();
        Ename_txt = new javax.swing.JTextField();
        year2_txt = new javax.swing.JTextField();
        month_txt = new javax.swing.JTextField();
        day_txt = new javax.swing.JTextField();
        sum_txt = new javax.swing.JTextField();
        date_txt = new javax.swing.JTextField();
        time_txt = new javax.swing.JTextField();
        jLabel81 = new javax.swing.JLabel();
        jLabel82 = new javax.swing.JLabel();
        jLabel83 = new javax.swing.JLabel();
        jLabel84 = new javax.swing.JLabel();
        jLabel85 = new javax.swing.JLabel();
        jLabel86 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        check_date = new javax.swing.JCheckBox();
        check_month = new javax.swing.JCheckBox();
        check_year = new javax.swing.JCheckBox();
        lable_date = new javax.swing.JLabel();
        lable_month = new javax.swing.JLabel();
        lable_year = new javax.swing.JLabel();
        day_now1 = new javax.swing.JTextField();
        jLabel92 = new javax.swing.JLabel();
        month_now1 = new javax.swing.JTextField();
        jLabel93 = new javax.swing.JLabel();
        year_now1 = new javax.swing.JTextField();
        year_now2 = new javax.swing.JTextField();
        year_now3 = new javax.swing.JTextField();
        combo_month4 = new javax.swing.JComboBox<>();
        jButton25 = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jLabel89 = new javax.swing.JLabel();
        combo_print = new javax.swing.JComboBox<>();
        jCheckBox4 = new javax.swing.JCheckBox();
        jButton12 = new javax.swing.JButton();
        jLabel27 = new javax.swing.JLabel();
        rad_employeeIngo = new javax.swing.JRadioButton();
        employee_work = new javax.swing.JRadioButton();
        invoices = new javax.swing.JRadioButton();
        radio_invoice = new javax.swing.JRadioButton();

        jPanel12.setBackground(new java.awt.Color(102, 102, 102));

        jLabel111.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Icons.png"))); // NOI18N

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel111, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel111, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1477, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 542, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 102, 0));
        jLabel1.setText("آسم المدير :");

        jTextField1.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(0, 102, 153));
        jTextField1.setText("Asrar Alharbi");
        jTextField1.setEnabled(false);

        jPanel13.setBackground(new java.awt.Color(102, 102, 102));

        jLabel112.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Icons.png"))); // NOI18N

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel112, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addComponent(jLabel112)
                .addGap(0, 4, Short.MAX_VALUE))
        );

        label_time.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        label_time.setForeground(new java.awt.Color(0, 102, 102));
        label_time.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Time-icon.png"))); // NOI18N

        label_date.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        label_date.setForeground(new java.awt.Color(0, 102, 102));
        label_date.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/calender-icon.png"))); // NOI18N

        jTabbedPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 2));
        jTabbedPane1.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 2));

        table_employee.setFont(new java.awt.Font("Lucida Grande", 1, 10)); // NOI18N
        table_employee.setForeground(new java.awt.Color(0, 102, 153));
        table_employee.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "رقم الموظف", "آسم الموظف", "وقت الدخول", "وقت الخروج", "اليوم", "الشهر", "السنة", "التاريخ"
            }
        ));
        table_employee.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_employeeMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table_employee);

        jLabel6.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 102, 0));
        jLabel6.setText("فرز حسب");

        combo_order.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        combo_order.setForeground(new java.awt.Color(0, 102, 153));
        combo_order.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "تصاعدياً", "تنازلياً", "ابجدياً", "عمراً" }));
        combo_order.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                combo_orderMouseClicked(evt);
            }
        });
        combo_order.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_orderActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        jLabel7.setText("رقم الموظف :");

        jLabel8.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        jLabel8.setText("الآسم الأول :");

        jLabel9.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        jLabel9.setText("الآسم الثاني :");

        jLabel10.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        jLabel10.setText("العمر :");

        jLabel11.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        jLabel11.setText("البريد الألكتروني :");

        jLabel12.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        jLabel12.setText("رقم الجوال :");

        jLabel13.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        jLabel13.setText("رقم الهاتف :");

        jLabel14.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        jLabel14.setText("الجنس :");

        jLabel15.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        jLabel15.setText("تاريخ الميلاد :");

        jLabel16.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        jLabel16.setText("الحالة الاجتماعية :");

        jLabel17.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        jLabel17.setText("الجنسية :");

        jLabel18.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        jLabel18.setText("العنوان :");

        jLabel19.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        jLabel19.setText("الدرجة العملية :");

        jLabel20.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        jLabel20.setText("درجة إجادة استخدام الحاسوب :");

        EI_txt.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        EI_txt.setForeground(new java.awt.Color(0, 102, 153));

        fname_txt.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        fname_txt.setForeground(new java.awt.Color(0, 102, 153));

        nationality_txt.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        nationality_txt.setForeground(new java.awt.Color(0, 102, 153));

        combo_age.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        combo_age.setForeground(new java.awt.Color(0, 102, 153));
        combo_age.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50" }));

        email_txt.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        email_txt.setForeground(new java.awt.Color(0, 102, 153));
        email_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                email_txtActionPerformed(evt);
            }
        });

        mobileNum_txt.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        mobileNum_txt.setForeground(new java.awt.Color(0, 102, 153));
        mobileNum_txt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                mobileNum_txtKeyTyped(evt);
            }
        });

        CR_txt.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        CR_txt.setForeground(new java.awt.Color(0, 102, 153));
        CR_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CR_txtActionPerformed(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        jLabel21.setText("السجل المدني :");

        telephoneNum_txt.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        telephoneNum_txt.setForeground(new java.awt.Color(0, 102, 153));
        telephoneNum_txt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                telephoneNum_txtKeyTyped(evt);
            }
        });

        buttonGroup1.add(radioButton_male);
        radioButton_male.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        radioButton_male.setForeground(new java.awt.Color(0, 102, 153));
        radioButton_male.setText("male");
        radioButton_male.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioButton_maleActionPerformed(evt);
            }
        });

        buttonGroup1.add(radioButton_female);
        radioButton_female.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        radioButton_female.setForeground(new java.awt.Color(0, 102, 153));
        radioButton_female.setText("female\n");
        radioButton_female.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioButton_femaleActionPerformed(evt);
            }
        });

        date_chooser.setForeground(new java.awt.Color(0, 102, 153));
        date_chooser.setDateFormatString("yyyy /MM/d ");

        combo_sotial.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        combo_sotial.setForeground(new java.awt.Color(0, 102, 153));
        combo_sotial.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "آعزب unmarried", "متزوج married", "مطلق separated", "آرمل widowed" }));
        combo_sotial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_sotialActionPerformed(evt);
            }
        });

        lname_txt1.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        lname_txt1.setForeground(new java.awt.Color(0, 102, 153));

        address_txt.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        address_txt.setForeground(new java.awt.Color(0, 102, 153));

        buttonGroup2.add(checkBox_1);
        checkBox_1.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        checkBox_1.setForeground(new java.awt.Color(0, 102, 153));
        checkBox_1.setText("Excellent");
        checkBox_1.setToolTipText("ممتاز");
        checkBox_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBox_1ActionPerformed(evt);
            }
        });

        buttonGroup2.add(checkBox_2);
        checkBox_2.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        checkBox_2.setForeground(new java.awt.Color(0, 102, 153));
        checkBox_2.setText("Good");
        checkBox_2.setToolTipText("جيد");
        checkBox_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBox_2ActionPerformed(evt);
            }
        });

        buttonGroup2.add(checkBox_3);
        checkBox_3.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        checkBox_3.setForeground(new java.awt.Color(0, 102, 153));
        checkBox_3.setText("Average");
        checkBox_3.setToolTipText("متوسط");
        checkBox_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBox_3ActionPerformed(evt);
            }
        });

        buttonGroup2.add(checkBox_4);
        checkBox_4.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        checkBox_4.setForeground(new java.awt.Color(0, 102, 153));
        checkBox_4.setText("Weak");
        checkBox_4.setToolTipText("ضعيف");
        checkBox_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBox_4ActionPerformed(evt);
            }
        });

        combo_qualification.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        combo_qualification.setForeground(new java.awt.Color(0, 102, 153));
        combo_qualification.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "شهادة الثانوية Certificate of Secondary Education", "بكالريوس" }));

        jButton1.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/edit-icon.png"))); // NOI18N
        jButton1.setText("تعديل");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Actions-list-add-user-icon.png"))); // NOI18N
        jButton2.setText("موظف جديد");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton7.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Adobe-PDF-Document-icon.png"))); // NOI18N
        jButton7.setText("حفظ PDF");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/1471535734_free-27.png"))); // NOI18N
        jButton8.setText("حذف موظف");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setFont(new java.awt.Font("Lucida Grande", 1, 10)); // NOI18N
        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/1471535620_free-38.png"))); // NOI18N
        jButton9.setText("تحديث الجدول");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jList1.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jList1.setForeground(new java.awt.Color(0, 0, 102));
        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jList1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList1MouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jList1);

        jLabel22.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        jLabel22.setText("الموظفين العاملين حالياً:");

        panel_search.setBackground(new java.awt.Color(204, 204, 204));
        panel_search.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 2));

        combo_month.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        combo_month.setForeground(new java.awt.Color(0, 102, 153));
        combo_month.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "January", "Febraury", "March", "April", "May", "Jun", "July", "August", "September", "October", "November", "December", " " }));

        year_txt.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        year_txt.setForeground(new java.awt.Color(0, 102, 153));
        year_txt.setText("السنة");
        year_txt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                year_txtKeyTyped(evt);
            }
        });

        buttonGroup6.add(search_month);
        search_month.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        search_month.setText("الشهر");
        search_month.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                search_monthMouseClicked(evt);
            }
        });
        search_month.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search_monthActionPerformed(evt);
            }
        });

        jButton10.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/resizedimage_2.png"))); // NOI18N
        jButton10.setText("بحث");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        buttonGroup6.add(search_year);
        search_year.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        search_year.setText("السنة");

        s_year.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        s_year.setForeground(new java.awt.Color(0, 102, 153));
        s_year.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        s_year.setText("السنة");
        s_year.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                s_yearKeyTyped(evt);
            }
        });

        s_month.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        s_month.setForeground(new java.awt.Color(0, 102, 153));
        s_month.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        s_month.setText("الشهر");
        s_month.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                s_monthKeyTyped(evt);
            }
        });

        s_day.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        s_day.setForeground(new java.awt.Color(0, 102, 153));
        s_day.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        s_day.setText("اليوم");
        s_day.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                s_dayKeyTyped(evt);
            }
        });

        jLabel25.setText("/");

        jLabel26.setText("/");

        buttonGroup6.add(search_date);
        search_date.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        search_date.setText("اليوم");

        year_txt3.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        year_txt3.setForeground(new java.awt.Color(0, 102, 153));
        year_txt3.setText("السنة");
        year_txt3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                year_txt3KeyTyped(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(153, 0, 51));
        jLabel23.setText("البحث حسب :");

        jCheckBox9.setFont(new java.awt.Font("Lucida Grande", 1, 10)); // NOI18N
        jCheckBox9.setForeground(new java.awt.Color(51, 102, 0));
        jCheckBox9.setText(" آخفاء القائمة ");
        jCheckBox9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel_searchLayout = new javax.swing.GroupLayout(panel_search);
        panel_search.setLayout(panel_searchLayout);
        panel_searchLayout.setHorizontalGroup(
            panel_searchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_searchLayout.createSequentialGroup()
                .addGroup(panel_searchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_searchLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jButton10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBox9))
                    .addGroup(panel_searchLayout.createSequentialGroup()
                        .addGroup(panel_searchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panel_searchLayout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addGroup(panel_searchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panel_searchLayout.createSequentialGroup()
                                        .addComponent(s_day, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel26)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(s_month, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel25)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(s_year, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panel_searchLayout.createSequentialGroup()
                                        .addComponent(year_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(15, 15, 15))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_searchLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(year_txt3, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(combo_month, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(panel_searchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel_searchLayout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(search_date))
                            .addGroup(panel_searchLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(panel_searchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(search_year)
                                    .addComponent(search_month)))))
                    .addGroup(panel_searchLayout.createSequentialGroup()
                        .addGap(194, 194, 194)
                        .addComponent(jLabel23)))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        panel_searchLayout.setVerticalGroup(
            panel_searchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_searchLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_searchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(search_date)
                    .addComponent(s_year, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25)
                    .addComponent(s_month, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26)
                    .addComponent(s_day, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_searchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(search_month)
                    .addComponent(combo_month, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(year_txt3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_searchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(year_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(search_year))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_searchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton10)
                    .addComponent(jCheckBox9))
                .addContainerGap(9, Short.MAX_VALUE))
        );

        jButton3.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/print-icon.png"))); // NOI18N
        jButton3.setText("طباعة");
        jButton3.setToolTipText("طباعة كافة الجدول");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        search_txt.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        search_txt.setForeground(new java.awt.Color(0, 102, 153));
        search_txt.setText("رقم الموظف أو رقم الجوال أو العمر");
        search_txt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                search_txtKeyPressed(evt);
            }
        });

        jButton6.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/1471535734_free-27.png"))); // NOI18N
        jButton6.setText("حذف ");
        jButton6.setToolTipText("حذف بيانات عمل موظف");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 153, 51));
        jLabel2.setText("آبحث");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(panel_search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 898, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel22)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(nationality_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(combo_sotial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(date_chooser, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(radioButton_female)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(radioButton_male)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(telephoneNum_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(mobileNum_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(checkBox_4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(checkBox_3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(checkBox_2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(checkBox_1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel20)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(combo_qualification, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel19)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(address_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(email_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(combo_age, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lname_txt1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fname_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CR_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel21)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(EI_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(469, 469, 469)
                                .addComponent(search_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 484, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel18)
                            .addComponent(jLabel7)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1245, 1245, 1245)
                        .addComponent(combo_order, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)))
                .addContainerGap(160, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(combo_order, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(search_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(EI_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21)
                    .addComponent(CR_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(fname_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(lname_txt1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(combo_age, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(email_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel12)
                        .addComponent(mobileNum_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(telephoneNum_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel13)
                        .addComponent(jLabel14)
                        .addComponent(radioButton_male)
                        .addComponent(radioButton_female)
                        .addComponent(jLabel15))
                    .addComponent(date_chooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel16)
                        .addComponent(combo_sotial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel17)
                        .addComponent(nationality_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(4, 4, 4)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkBox_4)
                    .addComponent(checkBox_3)
                    .addComponent(checkBox_2)
                    .addComponent(checkBox_1)
                    .addComponent(jLabel20)
                    .addComponent(combo_qualification, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19)
                    .addComponent(address_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addGap(8, 8, 8)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton9)
                        .addGap(8, 8, 8)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton6))
                    .addComponent(panel_search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(54, Short.MAX_VALUE))
        );

        jScrollPane3.setViewportView(jPanel1);

        jTabbedPane1.addTab("الموظفين", jScrollPane3);

        jPanel5.setBackground(new java.awt.Color(204, 204, 204));

        user_table.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        user_table.setForeground(new java.awt.Color(0, 102, 153));
        user_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "الاسم الاول", "الاسم الثاني", "البريد الالكتروني", "رقم الجوال", "كلمة المرور", "الجنس", "تاريخ الميلاد", "السعرات الحرارية", "العمر", "اليوم", "الشهر", "السنة", "التاريخ", "الوقت"
            }
        ));
        user_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                user_tableMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(user_table);

        jLabel51.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        jLabel51.setText("الآسم الاول :");

        jLabel52.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        jLabel52.setText("الآسم الثاني :");

        jLabel53.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        jLabel53.setText("البريد الإلكتروني :");

        jLabel54.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        jLabel54.setText("رقم الجوال :");

        jLabel55.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        jLabel55.setText("تاريخ الميلاد :");

        jLabel56.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        jLabel56.setText("العمر :");

        jLabel57.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        jLabel57.setText("السعرآت الحرارية :");

        jLabel58.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        jLabel58.setText("كلمة السر :");

        fanme_txt.setEditable(false);
        fanme_txt.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        fanme_txt.setForeground(new java.awt.Color(0, 102, 153));

        lname_txt.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        lname_txt.setForeground(new java.awt.Color(0, 102, 153));

        mail_txt.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        mail_txt.setForeground(new java.awt.Color(0, 102, 153));

        phone_txt.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        phone_txt.setForeground(new java.awt.Color(0, 102, 153));
        phone_txt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                phone_txtKeyTyped(evt);
            }
        });

        pass_txt.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        pass_txt.setForeground(new java.awt.Color(0, 102, 153));

        age_txt.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        age_txt.setForeground(new java.awt.Color(0, 102, 153));
        age_txt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                age_txtKeyTyped(evt);
            }
        });

        cal_txt.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        cal_txt.setForeground(new java.awt.Color(0, 102, 153));
        cal_txt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cal_txtKeyTyped(evt);
            }
        });

        date_choser.setForeground(new java.awt.Color(0, 102, 153));
        date_choser.setDateFormatString("d/MM/yyyy");

        buttonGroup8.add(rad_male);
        rad_male.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        rad_male.setForeground(new java.awt.Color(0, 102, 153));
        rad_male.setText("male");
        rad_male.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rad_maleActionPerformed(evt);
            }
        });

        buttonGroup8.add(rad_female);
        rad_female.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        rad_female.setForeground(new java.awt.Color(0, 102, 153));
        rad_female.setText("femal");
        rad_female.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rad_femaleActionPerformed(evt);
            }
        });

        jLabel60.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        jLabel60.setText("الجنس :");

        jButton13.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        jButton13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/edit-icon.png"))); // NOI18N
        jButton13.setText("تعديل");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jButton14.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        jButton14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/1471535734_free-27.png"))); // NOI18N
        jButton14.setText("حذف مستخدم");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        jButton15.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        jButton15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/print-icon.png"))); // NOI18N
        jButton15.setText(" طباعة");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        jButton16.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        jButton16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Actions-list-add-user-icon.png"))); // NOI18N
        jButton16.setText("مستخدم جديد");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        jButton17.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        jButton17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Adobe-PDF-Document-icon.png"))); // NOI18N
        jButton17.setText("حفظ PDF");
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });

        jButton18.setFont(new java.awt.Font("Lucida Grande", 1, 11)); // NOI18N
        jButton18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/1471535620_free-38.png"))); // NOI18N
        jButton18.setText("تحديث الجدول");
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });

        jButton19.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        jButton19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/resizedimage_2.png"))); // NOI18N
        jButton19.setText("بحث");
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });

        panel_search1.setBackground(new java.awt.Color(204, 204, 204));
        panel_search1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 2));

        combo_month3.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        combo_month3.setForeground(new java.awt.Color(0, 102, 153));
        combo_month3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "January", "Febraury", "March", "April", "May", "Jun", "July", "August", "September", "October", "November", "December", " " }));

        year_txt2.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        year_txt2.setForeground(new java.awt.Color(0, 102, 153));
        year_txt2.setText("السنة");
        year_txt2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                year_txt2KeyTyped(evt);
            }
        });

        buttonGroup9.add(search_month2);
        search_month2.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        search_month2.setText("الشهر");
        search_month2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                search_month2MouseClicked(evt);
            }
        });
        search_month2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search_month2ActionPerformed(evt);
            }
        });

        jButton20.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jButton20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/resizedimage_2.png"))); // NOI18N
        jButton20.setText("بحث");
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });

        jLabel61.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        jLabel61.setForeground(new java.awt.Color(153, 0, 51));
        jLabel61.setText("البحث حسب :");

        buttonGroup9.add(search_year2);
        search_year2.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        search_year2.setText("السنة");

        s_year1.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        s_year1.setForeground(new java.awt.Color(0, 102, 153));
        s_year1.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        s_year1.setText("السنة");
        s_year1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                s_year1KeyTyped(evt);
            }
        });

        s_month1.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        s_month1.setForeground(new java.awt.Color(0, 102, 153));
        s_month1.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        s_month1.setText("الشهر");
        s_month1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                s_month1KeyTyped(evt);
            }
        });

        s_day1.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        s_day1.setForeground(new java.awt.Color(0, 102, 153));
        s_day1.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        s_day1.setText("اليوم");
        s_day1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                s_day1KeyTyped(evt);
            }
        });

        jLabel65.setText("/");

        jLabel66.setText("/");

        buttonGroup9.add(search_date1);
        search_date1.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        search_date1.setText("التاريخ");

        s_year2.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        s_year2.setForeground(new java.awt.Color(0, 102, 153));
        s_year2.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        s_year2.setText("السنة");
        s_year2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                s_year2KeyTyped(evt);
            }
        });

        jCheckBox7.setFont(new java.awt.Font("Lucida Grande", 1, 10)); // NOI18N
        jCheckBox7.setForeground(new java.awt.Color(51, 102, 0));
        jCheckBox7.setText("آخفاء القائمة");
        jCheckBox7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel_search1Layout = new javax.swing.GroupLayout(panel_search1);
        panel_search1.setLayout(panel_search1Layout);
        panel_search1Layout.setHorizontalGroup(
            panel_search1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_search1Layout.createSequentialGroup()
                .addGroup(panel_search1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_search1Layout.createSequentialGroup()
                        .addGroup(panel_search1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel_search1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(panel_search1Layout.createSequentialGroup()
                                    .addGap(57, 57, 57)
                                    .addComponent(s_year2, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_search1Layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(s_day1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel66)))
                            .addGroup(panel_search1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jButton20)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel_search1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel_search1Layout.createSequentialGroup()
                                .addComponent(combo_month3, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(search_month2))
                            .addGroup(panel_search1Layout.createSequentialGroup()
                                .addGap(49, 49, 49)
                                .addComponent(year_txt2, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(search_year2))
                            .addGroup(panel_search1Layout.createSequentialGroup()
                                .addComponent(s_month1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel65)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(s_year1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(search_date1))))
                    .addGroup(panel_search1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jCheckBox7)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_search1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel61)
                .addGap(90, 90, 90))
        );
        panel_search1Layout.setVerticalGroup(
            panel_search1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_search1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel61)
                .addGap(7, 7, 7)
                .addGroup(panel_search1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(search_date1)
                    .addComponent(s_year1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel65)
                    .addComponent(s_month1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel66)
                    .addComponent(s_day1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_search1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(search_month2)
                    .addComponent(combo_month3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(s_year2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_search1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_search1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(year_txt2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(search_year2))
                    .addComponent(jButton20, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jCheckBox7)
                .addContainerGap())
        );

        search_txt1.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        search_txt1.setForeground(new java.awt.Color(0, 102, 153));
        search_txt1.setText("الآسم أو رقم الجوال أو العمر");
        search_txt1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                search_txt1KeyPressed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 153, 51));
        jLabel5.setText("آبحث");

        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/SignUP_icon1.png"))); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(0, 47, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(42, 42, 42))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addComponent(panel_search1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jButton19, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton18))
                            .addComponent(jButton16, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton14, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jButton17, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(121, 121, 121)
                                .addComponent(rad_female)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rad_male)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel60)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cal_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel57)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(age_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel56)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                                .addComponent(jLabel59)
                                                .addGap(280, 280, 280))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                                .addComponent(phone_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel54)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                        .addComponent(pass_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(lname_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel52)
                                    .addComponent(jLabel58))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(fanme_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel51))
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                                    .addComponent(date_choser, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel55))
                                .addGroup(jPanel5Layout.createSequentialGroup()
                                    .addComponent(mail_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel53))))
                        .addGap(267, 267, 267))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 894, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(676, 676, 676)
                .addComponent(search_txt1, javax.swing.GroupLayout.PREFERRED_SIZE, 484, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel24)
                        .addContainerGap())
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(search_txt1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel59)
                                .addGap(73, 73, 73))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(fanme_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel51)
                                    .addComponent(jLabel52)
                                    .addComponent(lname_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(mail_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel53)
                                    .addComponent(jLabel54)
                                    .addComponent(phone_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(pass_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel58))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel56)
                                .addComponent(age_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel57)
                                .addComponent(cal_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel60)
                                .addComponent(rad_male)
                                .addComponent(rad_female))
                            .addComponent(date_choser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel55))
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(jButton19, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(panel_search1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(jButton18)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton16)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton13)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton14)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton15)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton17)))
                                .addGap(0, 0, Short.MAX_VALUE))))))
        );

        jScrollPane7.setViewportView(jPanel5);

        jTabbedPane1.addTab("المستخدمين", jScrollPane7);

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        table_invoice.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        table_invoice.setForeground(new java.awt.Color(0, 102, 153));
        table_invoice.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "رقم الفاتورة", "آسم الموظف", "المجموع", "اليوم", "الشهر", "السنة", "التاريخ", "الوقت"
            }
        ));
        table_invoice.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_invoiceMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(table_invoice);

        jPanel6.setBackground(new java.awt.Color(204, 204, 204));
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 2));

        jButton4.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/resizedimage.jpg"))); // NOI18N
        jButton4.setText("عرض");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        buttonGroup7.add(select_year);
        select_year.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        select_year.setForeground(new java.awt.Color(204, 51, 0));
        select_year.setText("السنوية");
        select_year.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                select_yearActionPerformed(evt);
            }
        });

        txt_year1.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        txt_year1.setForeground(new java.awt.Color(0, 102, 153));
        txt_year1.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txt_year1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_year1KeyTyped(evt);
            }
        });

        buttonGroup7.add(select_day);
        select_day.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        select_day.setForeground(new java.awt.Color(204, 51, 0));
        select_day.setText("اليومية");
        select_day.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                select_dayActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(153, 0, 51));
        jLabel4.setText("قائمة الفواتير :");

        combo_month1.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        combo_month1.setForeground(new java.awt.Color(0, 102, 153));
        combo_month1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "January", "Febraury", "March", "April", "May", "Jun", "July", "August", "September", "October", "November", "December", " " }));

        buttonGroup7.add(select_month);
        select_month.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        select_month.setForeground(new java.awt.Color(204, 51, 0));
        select_month.setText("الشهرية");
        select_month.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                select_monthActionPerformed(evt);
            }
        });

        day_now2.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        day_now2.setForeground(new java.awt.Color(0, 102, 153));
        day_now2.setText("اليوم");
        day_now2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                day_now2KeyTyped(evt);
            }
        });

        jLabel94.setText("/");

        month_now2.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        month_now2.setForeground(new java.awt.Color(0, 102, 153));
        month_now2.setText("الشهر");
        month_now2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                month_now2KeyTyped(evt);
            }
        });

        jLabel95.setText("/");

        year_now4.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        year_now4.setForeground(new java.awt.Color(0, 102, 153));
        year_now4.setText("السنة");
        year_now4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                year_now4KeyTyped(evt);
            }
        });

        year_now5.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        year_now5.setForeground(new java.awt.Color(0, 102, 153));
        year_now5.setText("السنة");
        year_now5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                year_now5KeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap(104, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(select_year)
                        .addGap(45, 45, 45)
                        .addComponent(select_month)
                        .addGap(15, 15, 15))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(txt_year1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(combo_month1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(day_now2, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(select_day)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addContainerGap())
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel94, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(month_now2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel95)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(year_now4, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                        .addComponent(jButton4)
                        .addGap(2, 2, 2))))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(211, 211, 211)
                .addComponent(year_now5, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(select_year)
                    .addComponent(select_day)
                    .addComponent(jLabel4)
                    .addComponent(select_month))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_year1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4)
                    .addComponent(combo_month1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(day_now2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel94)
                    .addComponent(month_now2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel95)
                    .addComponent(year_now4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(year_now5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "الرسم البياني", javax.swing.border.TitledBorder.RIGHT, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 0, 51));
        jLabel3.setText("نوع الرسم البياني :");

        jButton5.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/resizedimage.jpg"))); // NOI18N
        jButton5.setText("عرض");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        buttonGroup4.add(line_chart);
        line_chart.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        line_chart.setForeground(new java.awt.Color(204, 51, 0));
        line_chart.setText("الرسم البياني الخطي");
        line_chart.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        line_chart.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        line_chart.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        buttonGroup4.add(bar_chart);
        bar_chart.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        bar_chart.setForeground(new java.awt.Color(204, 51, 0));
        bar_chart.setText("الرسم البياني العامودي");

        buttonGroup4.add(pie_chart);
        pie_chart.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        pie_chart.setForeground(new java.awt.Color(204, 51, 0));
        pie_chart.setText("الرسم البياني الدائري");
        pie_chart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pie_chartActionPerformed(evt);
            }
        });

        combo_foodTime.setBackground(new java.awt.Color(204, 204, 204));
        combo_foodTime.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 2));

        combo_month2.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        combo_month2.setForeground(new java.awt.Color(0, 102, 153));
        combo_month2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "January", "Febraury", "March", "April", "May", "Jun", "July", "August", "September", "October", "November", "December", " " }));
        combo_month2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_month2ActionPerformed(evt);
            }
        });

        year_txt1.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        year_txt1.setForeground(new java.awt.Color(0, 102, 153));
        year_txt1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                year_txt1KeyTyped(evt);
            }
        });

        buttonGroup10.add(search_month1);
        search_month1.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        search_month1.setText("الشهر");
        search_month1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search_month1ActionPerformed(evt);
            }
        });

        buttonGroup10.add(search_day1);
        search_day1.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        search_day1.setText("اليوم");
        search_day1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search_day1ActionPerformed(evt);
            }
        });

        buttonGroup10.add(search_year1);
        search_year1.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        search_year1.setText("السنة");
        search_year1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search_year1ActionPerformed(evt);
            }
        });

        buttonGroup5.add(months);
        months.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        months.setForeground(new java.awt.Color(0, 102, 153));
        months.setText("عرض حسب الاشهر");

        buttonGroup5.add(dayes);
        dayes.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        dayes.setForeground(new java.awt.Color(0, 102, 153));
        dayes.setText("عرض حسب الايام");

        javax.swing.GroupLayout jPanel_timeLayout = new javax.swing.GroupLayout(jPanel_time);
        jPanel_time.setLayout(jPanel_timeLayout);
        jPanel_timeLayout.setHorizontalGroup(
            jPanel_timeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_timeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(months)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dayes, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel_timeLayout.setVerticalGroup(
            jPanel_timeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_timeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_timeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dayes)
                    .addComponent(months))
                .addContainerGap())
        );

        day_now.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        day_now.setForeground(new java.awt.Color(0, 102, 153));
        day_now.setText("اليوم");
        day_now.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                day_nowKeyTyped(evt);
            }
        });

        month_now.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        month_now.setForeground(new java.awt.Color(0, 102, 153));
        month_now.setText("الشهر");
        month_now.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                month_nowKeyTyped(evt);
            }
        });

        year_now.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        year_now.setForeground(new java.awt.Color(0, 102, 153));
        year_now.setText("السنة");
        year_now.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                year_nowKeyTyped(evt);
            }
        });

        jLabel87.setText("/");

        jLabel88.setText("/");

        month_year.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        month_year.setForeground(new java.awt.Color(0, 102, 153));
        month_year.setText("السنة");
        month_year.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                month_yearKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout combo_foodTimeLayout = new javax.swing.GroupLayout(combo_foodTime);
        combo_foodTime.setLayout(combo_foodTimeLayout);
        combo_foodTimeLayout.setHorizontalGroup(
            combo_foodTimeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, combo_foodTimeLayout.createSequentialGroup()
                .addGroup(combo_foodTimeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, combo_foodTimeLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jPanel_time, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(combo_foodTimeLayout.createSequentialGroup()
                        .addGap(8, 14, Short.MAX_VALUE)
                        .addGroup(combo_foodTimeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(combo_foodTimeLayout.createSequentialGroup()
                                .addComponent(year_txt1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(search_year1))
                            .addGroup(combo_foodTimeLayout.createSequentialGroup()
                                .addGroup(combo_foodTimeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, combo_foodTimeLayout.createSequentialGroup()
                                        .addComponent(month_year, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(combo_month2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(6, 6, 6))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, combo_foodTimeLayout.createSequentialGroup()
                                        .addComponent(day_now, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel87, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(month_now, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(5, 5, 5)
                                        .addComponent(jLabel88)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(year_now, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)))
                                .addGroup(combo_foodTimeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(search_month1)
                                    .addComponent(search_day1))))))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        combo_foodTimeLayout.setVerticalGroup(
            combo_foodTimeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(combo_foodTimeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(combo_foodTimeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(search_day1)
                    .addComponent(day_now, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(month_now, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(year_now, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel87)
                    .addComponent(jLabel88))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(combo_foodTimeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(search_month1)
                    .addComponent(combo_month2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(month_year, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(combo_foodTimeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(year_txt1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(search_year1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel_time, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        combo_chartType.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        combo_chartType.setForeground(new java.awt.Color(0, 102, 153));
        combo_chartType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "نوع الطعام والكمية", "الارباح  " }));
        combo_chartType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_chartTypeActionPerformed(evt);
            }
        });

        combo_food.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        combo_food.setForeground(new java.awt.Color(0, 102, 153));
        combo_food.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "المقبلات ", "شوربة", "معكرونة", "آطباق الدجاج", "آطباق اللحم", "آطباق الأرز", "السلطات", "المشروبات", "العصائر ", " ", " " }));

        rad_save.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        rad_save.setForeground(new java.awt.Color(0, 153, 0));
        rad_save.setText("حفظ بصيغة  png");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jButton5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bar_chart)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(pie_chart)
                                    .addComponent(line_chart))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3)))
                        .addGap(181, 181, 181))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(combo_foodTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(combo_food, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(combo_chartType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(rad_save)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(pie_chart)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bar_chart))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(line_chart)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(combo_food, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combo_chartType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rad_save)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(combo_foodTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jButton22.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jButton22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/print-icon.png"))); // NOI18N
        jButton22.setText("طباعة");
        jButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton22ActionPerformed(evt);
            }
        });

        jLabel79.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        jLabel79.setText("رقم الفاتورة :");

        id_txt.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        id_txt.setForeground(new java.awt.Color(0, 102, 153));

        jLabel80.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        jLabel80.setText("آسم الموظف :");
        jLabel80.setToolTipText("");

        Ename_txt.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        Ename_txt.setForeground(new java.awt.Color(0, 102, 153));

        year2_txt.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        year2_txt.setForeground(new java.awt.Color(0, 102, 153));

        month_txt.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        month_txt.setForeground(new java.awt.Color(0, 102, 153));

        day_txt.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        day_txt.setForeground(new java.awt.Color(0, 102, 153));

        sum_txt.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        sum_txt.setForeground(new java.awt.Color(0, 102, 153));

        date_txt.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        date_txt.setForeground(new java.awt.Color(0, 102, 153));

        time_txt.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        time_txt.setForeground(new java.awt.Color(0, 102, 153));

        jLabel81.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        jLabel81.setText("المجموع :");

        jLabel82.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        jLabel82.setText("اليوم :");

        jLabel83.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        jLabel83.setText("الشهر :");

        jLabel84.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        jLabel84.setText("السنة :");

        jLabel85.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        jLabel85.setText("التاريخ :");

        jLabel86.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        jLabel86.setText("الوقت :");

        jPanel7.setBackground(new java.awt.Color(204, 204, 204));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "مجموع الآرباح", javax.swing.border.TitledBorder.RIGHT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Grande", 1, 12), new java.awt.Color(204, 51, 0))); // NOI18N

        buttonGroup11.add(check_date);
        check_date.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        check_date.setForeground(new java.awt.Color(204, 51, 0));
        check_date.setText("التاريخ");

        buttonGroup11.add(check_month);
        check_month.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        check_month.setForeground(new java.awt.Color(204, 51, 0));
        check_month.setText("الشهر");

        buttonGroup11.add(check_year);
        check_year.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        check_year.setForeground(new java.awt.Color(204, 51, 0));
        check_year.setText("السنة");

        lable_date.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        lable_date.setForeground(new java.awt.Color(102, 0, 0));
        lable_date.setText("...");

        lable_month.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        lable_month.setForeground(new java.awt.Color(102, 0, 0));
        lable_month.setText("...");

        lable_year.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        lable_year.setForeground(new java.awt.Color(102, 0, 0));
        lable_year.setText("...");

        day_now1.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        day_now1.setForeground(new java.awt.Color(0, 102, 153));
        day_now1.setText("اليوم");
        day_now1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                day_now1KeyTyped(evt);
            }
        });

        jLabel92.setText("/");

        month_now1.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        month_now1.setForeground(new java.awt.Color(0, 102, 153));
        month_now1.setText("الشهر");
        month_now1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                month_now1KeyTyped(evt);
            }
        });

        jLabel93.setText("/");

        year_now1.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        year_now1.setForeground(new java.awt.Color(0, 102, 153));
        year_now1.setText("السنة");
        year_now1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                year_now1KeyTyped(evt);
            }
        });

        year_now2.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        year_now2.setForeground(new java.awt.Color(0, 102, 153));
        year_now2.setText("السنة");
        year_now2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                year_now2ActionPerformed(evt);
            }
        });
        year_now2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                year_now2KeyTyped(evt);
            }
        });

        year_now3.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        year_now3.setForeground(new java.awt.Color(0, 102, 153));
        year_now3.setText("السنة");
        year_now3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                year_now3KeyTyped(evt);
            }
        });

        combo_month4.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        combo_month4.setForeground(new java.awt.Color(0, 102, 153));
        combo_month4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "January", "Febraury", "March", "April", "May", "Jun", "July", "August", "September", "October", "November", "December", " " }));
        combo_month4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_month4ActionPerformed(evt);
            }
        });

        jButton25.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jButton25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/resizedimage.jpg"))); // NOI18N
        jButton25.setText("عرض");
        jButton25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton25ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lable_month)
                            .addComponent(check_date)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addComponent(day_now1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel92, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(check_month))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(month_now1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel93)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(year_now1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(check_year)
                            .addComponent(year_now3, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(lable_year))
                            .addComponent(lable_date)))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(combo_month4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton25)
                            .addComponent(year_now2, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(8, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(check_date)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(day_now1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel92)
                    .addComponent(month_now1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel93)
                    .addComponent(year_now1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lable_date)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(check_month)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(year_now2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combo_month4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lable_month)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(check_year)
                .addGap(9, 9, 9)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(year_now3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lable_year))
                    .addComponent(jButton25, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        jLabel89.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        jLabel89.setForeground(new java.awt.Color(153, 0, 0));
        jLabel89.setText("آختر نوع الطباعة ");

        combo_print.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        combo_print.setForeground(new java.awt.Color(0, 102, 153));
        combo_print.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "طباعة كافة الجدول", "طباعة الصف المحدد ", " " }));
        combo_print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_printActionPerformed(evt);
            }
        });

        jCheckBox4.setFont(new java.awt.Font("Lucida Grande", 1, 10)); // NOI18N
        jCheckBox4.setForeground(new java.awt.Color(51, 102, 0));
        jCheckBox4.setText("آخفاء القائمة");
        jCheckBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(0, 46, Short.MAX_VALUE)
                .addComponent(combo_print, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jCheckBox4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel89)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel89, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jCheckBox4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(combo_print, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jButton12.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/1471535734_free-27.png"))); // NOI18N
        jButton12.setText("حذف");
        jButton12.setToolTipText("حذف الصف المحدد");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/203819-200.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(61, 61, 61)
                                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(89, 89, 89))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addComponent(Ename_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel80)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(id_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel79)
                                        .addGap(21, 21, 21)))
                                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(14, 14, 14)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(time_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel86)
                                                .addGap(9, 9, 9)
                                                .addComponent(date_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel85)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(sum_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel81)
                                                .addGap(172, 172, 172))
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(year2_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel84)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(month_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel83)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(day_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel82)
                                                .addGap(63, 63, 63))))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 788, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(34, 34, 34)))
                                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(124, 124, 124)
                        .addComponent(jButton22, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(199, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(id_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel79)
                            .addComponent(jLabel80))
                        .addContainerGap(428, Short.MAX_VALUE))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Ename_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel81)
                    .addComponent(sum_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel85)
                    .addComponent(date_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(time_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel86))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(year2_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel84)
                            .addComponent(month_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel83)
                            .addComponent(day_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel82))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton12)
                .addContainerGap(84, Short.MAX_VALUE))
        );

        jScrollPane6.setViewportView(jPanel2);

        jTabbedPane1.addTab("الفواتير", jScrollPane6);

        buttonGroup3.add(rad_employeeIngo);
        rad_employeeIngo.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        rad_employeeIngo.setForeground(new java.awt.Color(51, 102, 0));
        rad_employeeIngo.setText("بيانات الموظفين");
        rad_employeeIngo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rad_employeeIngoActionPerformed(evt);
            }
        });

        buttonGroup3.add(employee_work);
        employee_work.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        employee_work.setForeground(new java.awt.Color(51, 102, 0));
        employee_work.setText("متابعة عمل الموظفين");
        employee_work.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employee_workActionPerformed(evt);
            }
        });

        buttonGroup3.add(invoices);
        invoices.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        invoices.setForeground(new java.awt.Color(51, 102, 0));
        invoices.setText("الفواتير ");
        invoices.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                invoicesActionPerformed(evt);
            }
        });

        buttonGroup3.add(radio_invoice);
        radio_invoice.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        radio_invoice.setForeground(new java.awt.Color(51, 102, 0));
        radio_invoice.setText("المستخدمين");
        radio_invoice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radio_invoiceActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(label_date)
                .addGap(18, 18, 18)
                .addComponent(label_time)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(invoices)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(radio_invoice)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(employee_work)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rad_employeeIngo)
                .addGap(28, 28, 28)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(label_time)
                        .addComponent(label_date))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(radio_invoice)
                        .addComponent(invoices)
                        .addComponent(employee_work)
                        .addComponent(rad_employeeIngo)
                        .addComponent(jLabel1)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 647, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

        if (line_chart.isSelected()) {
            chart_line();
        } else if (pie_chart.isSelected()) {
            chart_pie();
        } else if (bar_chart.isSelected()) {
            chart_bar();
        }

    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        DefaultTableModel model = (DefaultTableModel) table_invoice.getModel();

        if (select_day.isSelected()) {

            int day1 = Integer.parseInt(day_now2.getText());
            int month1 = Integer.parseInt(month_now2.getText());
            int year1 = Integer.parseInt(year_now4.getText());
            String date = "" + day1 + "/" + month1 + "/" + year1 + "";
            model.setRowCount(0);
            try {
                String sql = "select * from invoices where date = '" + date + "' ";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();

                while (rs.next()) {
                    Vector<Object> rows = new Vector<Object>();
                    rows.add(rs.getString("invoice_id"));
                    rows.add(rs.getString("employee_name"));
                    rows.add(rs.getString("total"));
                    rows.add(rs.getString("day"));
                    rows.add(rs.getString("month"));
                    rows.add(rs.getString("year"));
                    rows.add(rs.getString("date"));
                    rows.add(rs.getString("time"));

                    model.addRow(rows);
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            } finally {
                try {
                    pst.close();
                    rs.close();

                } catch (SQLException ex) {
                    Logger.getLogger(Management.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
            }

        } else if (select_month.isSelected()) {

            String month = combo_month1.getSelectedItem().toString();
            String month_year = year_now5.getText();
            model.setRowCount(0);
            try {
                String sql = "select  * from invoices where month = '" + month + "' and year = '" + month_year + "' ";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();

                while (rs.next()) {
                    Vector<Object> rows = new Vector<Object>();
                    rows.add(rs.getString("invoice_id"));
                    rows.add(rs.getString("employee_name"));
                    rows.add(rs.getString("total"));
                    rows.add(rs.getString("day"));
                    rows.add(rs.getString("month"));
                    rows.add(rs.getString("year"));
                    rows.add(rs.getString("date"));
                    rows.add(rs.getString("time"));

                    model.addRow(rows);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            } finally {
                try {
                    pst.close();
                    rs.close();

                } catch (SQLException ex) {
                    Logger.getLogger(Management.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
            }

        } else if (select_year.isSelected()) {

            String year = txt_year1.getText();
            try {
                String sql = "select * from invoices where year = '" + year + "' ";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                model.setRowCount(0);
                //Vector<Object> rows = new Vector<Object>();
                while (rs.next()) {
                    Vector<Object> rows = new Vector<Object>();
                    rows.add(rs.getString("invoice_id"));
                    rows.add(rs.getString("employee_name"));
                    rows.add(rs.getString("total"));
                    rows.add(rs.getString("day"));
                    rows.add(rs.getString("month"));
                    rows.add(rs.getString("year"));
                    rows.add(rs.getString("date"));
                    rows.add(rs.getString("time"));

                    model.addRow(rows);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            } finally {
                try {
                    pst.close();
                    rs.close();

                } catch (SQLException ex) {
                    Logger.getLogger(Management.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }//GEN-LAST:event_jButton4ActionPerformed

    private void CR_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CR_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CR_txtActionPerformed

    private void email_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_email_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_email_txtActionPerformed

    private void combo_sotialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_sotialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combo_sotialActionPerformed

    private void table_employeeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_employeeMouseClicked

        int selected_row = table_employee.getSelectedRow();
        String table_click = table_employee.getModel().getValueAt(selected_row, 0).toString();

        if (employee_work.isSelected()) {
            try {
                String sql = "select * from employeeInfo where employee_id = '" + table_click + "' ";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                if (rs.next()) {
                    String add1 = rs.getString("employee_id");
                    EI_txt.setText(add1);
                    String add2 = rs.getString("civilRegistry");
                    CR_txt.setText(add2);
                    String add3 = rs.getString("fname");
                    fname_txt.setText(add3);
                    String add4 = rs.getString("lname");
                    lname_txt1.setText(add4);
                    String add5 = rs.getString("age");
                    combo_age.setSelectedItem(add5);
                    String add6 = rs.getString("email");
                    email_txt.setText(add6);
                    String add7 = rs.getString("mobileNum");
                    mobileNum_txt.setText(add7);
                    String add8 = rs.getString("telephoneNum");
                    telephoneNum_txt.setText(add8);
                    String add9 = rs.getString("gender");
                    if (add9.equals("male")) {
                        radioButton_male.setSelected(true);
                    } else {
                        radioButton_female.setSelected(true);
                    }

                    String add10 = rs.getString("date");
                    ((JTextField) date_chooser.getDateEditor().getUiComponent()).setText(add10);
                    String add11 = rs.getString("socialStatus");
                    if (add11.equals("unmarried")) {
                        combo_sotial.setSelectedIndex(0);
                    } else if (add11.equals("married")) {
                        combo_sotial.setSelectedIndex(1);
                    } else if (add11.equals("separated")) {
                        combo_sotial.setSelectedIndex(2);
                    } else if (add11.equals("widowed")) {
                        combo_sotial.setSelectedIndex(3);
                    }
                    String add12 = rs.getString("nationality");
                    nationality_txt.setText(add12);
                    String add13 = rs.getString("address");
                    address_txt.setText(add13);
                    String add14 = rs.getString("qualification");
                    if (add14.equals("Certificate of Secondary Education")) {
                        combo_qualification.setSelectedIndex(1);
                    } else if (add14.equals("Bachelor")) {
                        combo_qualification.setSelectedIndex(2);
                    }
                    // combo_qualification.setSelectedItem(add14);
                    String add15 = rs.getString("DICE");
                    if (add15.equals("excellent")) {
                        checkBox_1.setSelected(true);
                    } else if (add15.equals("good")) {
                        checkBox_2.setSelected(true);
                    } else if (add15.equals("average")) {
                        checkBox_3.setSelected(true);
                    } else if (add15.equals("weak")) {
                        checkBox_4.setSelected(true);
                    }

                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            } finally {
                try {
                    pst.close();
                    rs.close();

                } catch (SQLException ex) {
                    Logger.getLogger(Management.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else if (rad_employeeIngo.isSelected()) {

            try {
                String sql = "select * from employeeInfo where employee_id = '" + table_click + "' ";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                if (rs.next()) {
                    String add1 = rs.getString("employee_id");
                    EI_txt.setText(add1);
                    String add2 = rs.getString("civilRegistry");
                    CR_txt.setText(add2);
                    String add3 = rs.getString("fname");
                    fname_txt.setText(add3);
                    String add4 = rs.getString("lname");
                    lname_txt1.setText(add4);
                    String add5 = rs.getString("age");
                    combo_age.setSelectedItem(add5);
                    String add6 = rs.getString("email");
                    email_txt.setText(add6);
                    String add7 = rs.getString("mobileNum");
                    mobileNum_txt.setText(add7);
                    String add8 = rs.getString("telephoneNum");
                    telephoneNum_txt.setText(add8);
                    String add9 = rs.getString("gender");
                    if (add9.equals("male")) {
                        radioButton_male.setSelected(true);
                    } else if (add9.equals("female")) {
                        radioButton_female.setSelected(true);
                    }
                    String add10 = rs.getString("date");
                    ((JTextField) date_chooser.getDateEditor().getUiComponent()).setText(add10);
                    String add11 = rs.getString("socialStatus");
                    if (add11.equals("unmarried")) {
                        combo_sotial.setSelectedIndex(0);
                    } else if (add11.equals("married")) {
                        combo_sotial.setSelectedIndex(1);
                    } else if (add11.equals("separated")) {
                        combo_sotial.setSelectedIndex(2);
                    } else if (add11.equals("widowed")) {
                        combo_sotial.setSelectedIndex(3);
                    }
                    String add12 = rs.getString("nationality");
                    nationality_txt.setText(add12);
                    String add13 = rs.getString("address");
                    address_txt.setText(add13);
                    String add14 = rs.getString("qualification");
                    if (add14.equals("Certificate of Secondary Education")) {
                        combo_qualification.setSelectedIndex(1);
                    } else if (add14.equals("Bachelor")) {
                        combo_qualification.setSelectedIndex(2);
                    }
                    combo_qualification.setSelectedItem(add14);
                    String add15 = rs.getString("DICE");
                    if (add15.equals("excellent")) {
                        checkBox_1.setSelected(true);
                    } else if (add15.equals("good")) {
                        checkBox_2.setSelected(true);
                    } else if (add15.equals("average")) {
                        checkBox_3.setSelected(true);
                    } else if (add15.equals("weak")) {
                        checkBox_4.setSelected(true);
                    }

                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            } finally {
                try {
                    pst.close();
                    rs.close();

                } catch (SQLException ex) {
                    Logger.getLogger(Management.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_table_employeeMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        try {
            String edit = EI_txt.getText();
            String edit1 = fname_txt.getText();
            String edit2 = lname_txt1.getText();
            String edit3 = combo_age.getSelectedItem().toString();
            String edit4 = mobileNum_txt.getText();
            String edit5 = telephoneNum_txt.getText();
            if (radioButton_male.isSelected()) {
                gender = "male";
            } else if (radioButton_female.isSelected()) {
                gender = "female";
            }
            String edit6 = gender;
            String edit7 = ((JTextField) date_chooser.getDateEditor().getUiComponent()).getText();

            int select_s = combo_sotial.getSelectedIndex();
            if (select_s == 0) {
                sotial = "unmarried";
            } else if (select_s == 1) {
                sotial = "married";
            } else if (select_s == 2) {
                sotial = "separated";
            } else if (select_s == 3) {
                sotial = "widowed";
            }
            String edit8 = sotial;
            String edit9 = nationality_txt.getText();
            String edit10 = address_txt.getText();
            int select = combo_qualification.getSelectedIndex();
            if (select == 1) {
                edu = "Certificate of Secondary Education";
            } else if (select == 2) {
                edu = "Bachelor";
            }
            String edit11 = edu;

            if (checkBox_1.isSelected()) {
                DICE = "excellent";
            } else if (checkBox_2.isSelected()) {
                DICE = "good";
            } else if (checkBox_3.isSelected()) {
                DICE = "average";
            } else if (checkBox_4.isSelected()) {
                DICE = "weak";
            }
            String edit12 = DICE;

            String sql = "update employeeinfo set fname='" + edit1 + "' , lname='" + edit2 + "' , age='" + edit3 + "' , "
                    + "mobileNum='" + edit4 + "' , telephoneNum='" + edit5 + "' , gender='" + edit6 + "' , date='" + edit7 + "' ,"
                    + "socialStatus='" + edit8 + "' , nationality='" + edit9 + "',address='" + edit10 + "' , qualification='" + edit11 + "' , "
                    + "DICE='" + edit12 + "' where employee_id = '" + edit + "'";
            pst = con.prepareStatement(sql);

            pst.execute();

            JOptionPane.showMessageDialog(null, "تم تحديث البيانات بنجاح", "تحديث البيانات", JOptionPane.OK_OPTION);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            try {
                pst.close();
                rs.close();

            } catch (SQLException ex) {
                Logger.getLogger(Management.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }
        update_table();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void radioButton_maleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioButton_maleActionPerformed
        gender = "male";
    }//GEN-LAST:event_radioButton_maleActionPerformed

    private void radioButton_femaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioButton_femaleActionPerformed
        gender = "female";
    }//GEN-LAST:event_radioButton_femaleActionPerformed

    private void checkBox_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBox_1ActionPerformed
        DICE = "ممتاز";
    }//GEN-LAST:event_checkBox_1ActionPerformed

    private void checkBox_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBox_2ActionPerformed
        DICE = "جيد";
    }//GEN-LAST:event_checkBox_2ActionPerformed

    private void checkBox_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBox_3ActionPerformed
        DICE = "متوسط";
    }//GEN-LAST:event_checkBox_3ActionPerformed

    private void checkBox_4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBox_4ActionPerformed
        DICE = "ضعيف";
    }//GEN-LAST:event_checkBox_4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        new EmployeesInfo().setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed

        int p = JOptionPane.showConfirmDialog(null, "هل ترغب في تآكيد الطلب ؟", "حذف بيانات موظف ", JOptionPane.YES_NO_OPTION);
        if (p == 0) {
            try {

                String value = EI_txt.getText();
                String sql = "delete from employeeInfo where employee_id = '" + value + "' ";
                pst = con.prepareStatement(sql);
                pst.execute();
                JOptionPane.showMessageDialog(null, "تم حذف البيانات بنجاح", "حذف بيانات موظف ", JOptionPane.CLOSED_OPTION);

                pst.close();

                update_table();

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            } finally {
                try {
                    pst.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Management.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }


    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        update_table();
        fillList();
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed

        String id = EI_txt.getText();
        String CR = CR_txt.getText();
        String fname = fname_txt.getText();
        String lname = lname_txt1.getText();
        String age = combo_age.getSelectedItem().toString();
        String mobileNum = mobileNum_txt.getText();
        String telephoneNum = telephoneNum_txt.getText();
        String email = email_txt.getText();
        if (radioButton_male.isSelected()) {
            gender = "male";
        } else if (radioButton_female.isSelected()) {
            gender = "female";
        }
        String gender1 = gender;
        String date = ((JTextField) date_chooser.getDateEditor().getUiComponent()).getText();
        int select_s = combo_sotial.getSelectedIndex();
        if (select_s == 0) {
            sotial = "unmarried";
        } else if (select_s == 1) {
            sotial = "married";
        } else if (select_s == 2) {
            sotial = "separated";
        } else if (select_s == 3) {
            sotial = "widowed";
        }
        String sotial_stuties = sotial;
        String nationality = nationality_txt.getText();
        String address = address_txt.getText();
        int select_d = combo_qualification.getSelectedIndex();
        if (select_d == 1) {
            edu = "Certificate of Secondary Education";
        } else if (select_d == 2) {
            edu = "Bachelor";
        }
        String qualification = edu;
        if (checkBox_1.isSelected()) {
            DICE = "excellent";
        } else if (checkBox_2.isSelected()) {
            DICE = "good";
        } else if (checkBox_3.isSelected()) {
            DICE = "average";
        } else if (checkBox_4.isSelected()) {
            DICE = "weak";
        }
        String DICE1 = DICE;

        try {
            Document doc = new Document();
            PdfWriter.getInstance(doc, new FileOutputStream("Employee info.pdf"));// عنون الفايل اللي راح احفظه مع النوع وراح ينحفظ تلقائيا في مجلد البرنامج
            doc.open();
            // لاضافة صورة مع الملاحظه ان موقع الصورة يأتي حسب موقعها في الكود وان تكون الصورة محفوظه في نفس المجلد الموجود به الفايل او التقرير
            Image image = Image.getInstance("Picture1.png"); // يوضع عنوان الصورة المراد وضعها مع نوعها 
            // doc.add(new Paragraph("Image")); // لاضافة عنوان للصورة حسب الرغبه 
            doc.add(image);

            // العنوان او رأس الصفحة
            doc.add(new Paragraph("                                   Employee Information", FontFactory.getFont(FontFactory.TIMES_ITALIC, 20, Font.BOLD, BaseColor.DARK_GRAY)));
            //doc.add(new Paragraph(new Date().toString()));// لاضافة الوقت و التاريخ آسفل العنوان 
            doc.add(new Paragraph("          ___________________________________________________________________\n"));
            doc.add(new Paragraph("                                                                     "));
            // اضافة جدول 
            /* PdfPTable table = new PdfPTable(3);// يحدد عدد الاعمدة  والعناصر التي تضاف تكون مضاعفات هذا العد مثل
    // ٣ او٦ او  ٩ وهكذا
    // اضافة عنوان للجدول 
    PdfPCell cell = new PdfPCell (new Paragraph("Table for Employees in the resturant"));
    cell.setColspan(4);//لتحديد مساحة العنوان بعدد الاعمدة 
    cell.setHorizontalAlignment(Element.ALIGN_CENTER);// موقع العنوان 
    cell.setBackgroundColor(BaseColor.LIGHT_GRAY);// لتغيير خلفية العنوان
    table.addCell(cell);//اضافة العنوان للجدول 
    
    table.addCell("Item1");
    table.addCell("Item2");
    table.addCell("Item3");
    
    doc.add(table);*/
            PdfPTable table = new PdfPTable(2);
            PdfPCell titel = new PdfPCell(new Paragraph("Employee Information", FontFactory.getFont(FontFactory.TIMES_ITALIC, 20, BaseColor.WHITE)));
            titel.setRowspan(3);
            titel.setColspan(2);

            titel.setHorizontalAlignment(Element.ALIGN_CENTER);
            titel.setBackgroundColor(BaseColor.LIGHT_GRAY);
            table.addCell(titel);

            table.addCell("Employee number ");
            table.addCell(id);
            table.addCell("Civil registry");
            table.addCell(CR);
            table.addCell("First name");
            table.addCell(fname);
            table.addCell("Second name");
            table.addCell(lname);
            table.addCell("Age");
            table.addCell(age);
            table.addCell("Mobile number");
            table.addCell(mobileNum);
            table.addCell("Telephone number");
            table.addCell(telephoneNum);
            table.addCell("Email");
            table.addCell(email);
            table.addCell("Gender");
            table.addCell(gender1);
            table.addCell("Social status");
            table.addCell(sotial_stuties);
            table.addCell("Nationality");
            table.addCell(nationality);
            table.addCell("Address");
            table.addCell(address);
            table.addCell("Degree");
            table.addCell(qualification);
            table.addCell("The degree of proficiency in computer use");
            table.addCell(DICE1);

            doc.add(table);
            /*// لاضافة قائمة ويكون موقعها حسب الموقع في الكود
    List list = new List ();// راح تعرض القائمة بشرطات 
   // List list = new List (true,20);// لعرض القائمة مرقمة للعدد اللي احدده
    list.add("Frist Item");
    list.add("Second Item");
    list.add("Third Item");
    list.add("Fourth Item");
    doc.add(list);*/

            doc.close();
            JOptionPane.showMessageDialog(null, "تم حفظ الملف بنجاح ");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void rad_employeeIngoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rad_employeeIngoActionPerformed
        panel_search.setVisible(false);

        jButton9.setVisible(true);
        jButton2.setVisible(true);
        jButton1.setVisible(true);
        jButton8.setVisible(true);
        jButton7.setVisible(true);
        jButton3.setVisible(true);
        jButton6.setVisible(false);
        search_txt.setVisible(true);
        jLabel2.setVisible(true);
        jLabel22.setVisible(true);
        jList1.setVisible(true);
        combo_order.setVisible(true);
        jLabel6.setVisible(true);
        jTabbedPane1.setSelectedIndex(0);
        update_table();
    }//GEN-LAST:event_rad_employeeIngoActionPerformed

    private void employee_workActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employee_workActionPerformed
        jTabbedPane1.setSelectedIndex(0);
        jButton9.setVisible(false);
        jButton2.setVisible(false);
        jButton1.setVisible(false);
        jButton8.setVisible(false);
        jButton7.setVisible(false);
        jButton3.setVisible(false);
        jButton6.setVisible(true);
        panel_search.setVisible(true);
        search_txt.setVisible(false);
        jLabel2.setVisible(false);
        jLabel22.setVisible(false);
        jList1.setVisible(false);
        combo_order.setVisible(false);
        jLabel6.setVisible(false);
        jCheckBox9.setSelected(false);
        update_table1();
    }//GEN-LAST:event_employee_workActionPerformed

    private void invoicesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_invoicesActionPerformed
        panel_search.setVisible(false);
        search_day1.setSelected(false);
        search_month1.setSelected(false);
        search_year1.setSelected(false);
        jTabbedPane1.setSelectedIndex(2);
        jPanel8.setVisible(false);
        
        update_table2();
    }//GEN-LAST:event_invoicesActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed

        jTabbedPane1.setSelectedIndex(0);
        update_table1();
        DefaultTableModel model = (DefaultTableModel) table_employee.getModel();
        if (search_date.isSelected() && employee_work.isSelected()) {
            model.setRowCount(0);
            int day = Integer.parseInt(s_day.getText());
            int month = Integer.parseInt(s_month.getText());
            int year = Integer.parseInt(s_year.getText());
            String date = "" + day + "/" + month + "/" + year + "";
            try {
                String sql = "select * from employeeWork where date = ? ";

                pst = con.prepareStatement(sql);
                pst.setString(1, date);
                rs = pst.executeQuery();

                Vector<Object> rows;

                while (rs.next()) {

                    rows = new Vector<Object>();

                    rows.add(rs.getString("employee_id"));
                    rows.add(rs.getString("name"));
                    rows.add(rs.getString("login_time"));
                    rows.add(rs.getString("logout_time"));
                    rows.add(rs.getString("day"));
                    rows.add(rs.getString("month"));
                    rows.add(rs.getString("year"));
                    rows.add(rs.getString("date"));

                    model.addRow(rows);
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            } finally {
                try {
                    pst.close();
                    rs.close();

                } catch (SQLException ex) {
                    Logger.getLogger(Management.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
            }

        } else if (search_month.isSelected() && employee_work.isSelected()) {
            model.setRowCount(0);
            String select_month = combo_month.getSelectedItem().toString();
            String year_month = year_txt3.getText();
            try {
                String sql = "select * from employeeWork where month = ? and year = ? ";

                pst = con.prepareStatement(sql);
                pst.setString(1, select_month);
                pst.setString(2, year_month);
                rs = pst.executeQuery();

                Vector<Object> rows;

                while (rs.next()) {

                    rows = new Vector<Object>();

                    rows.add(rs.getString("employee_id"));
                    rows.add(rs.getString("name"));
                    rows.add(rs.getString("login_time"));
                    rows.add(rs.getString("logout_time"));
                    rows.add(rs.getString("day"));
                    rows.add(rs.getString("month"));
                    rows.add(rs.getString("year"));
                    rows.add(rs.getString("date"));

                    model.addRow(rows);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            } finally {
                try {
                    pst.close();
                    rs.close();

                } catch (SQLException ex) {
                    Logger.getLogger(Management.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else if (search_year.isSelected() && employee_work.isSelected()) {
            model.setRowCount(0);
            String select_year = year_txt.getText();
            try {
                String sql = "select * from employeeWork where year = ? ";

                pst = con.prepareStatement(sql);
                pst.setString(1, select_year);
                rs = pst.executeQuery();

                Vector<Object> rows;

                while (rs.next()) {

                    rows = new Vector<Object>();

                    rows.add(rs.getString("employee_id"));
                    rows.add(rs.getString("name"));
                    rows.add(rs.getString("login_time"));
                    rows.add(rs.getString("logout_time"));
                    rows.add(rs.getString("day"));
                    rows.add(rs.getString("month"));
                    rows.add(rs.getString("year"));
                    rows.add(rs.getString("date"));

                    model.addRow(rows);
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            } finally {
                try {
                    pst.close();
                    rs.close();

                } catch (SQLException ex) {
                    Logger.getLogger(Management.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
            }

        }

    }//GEN-LAST:event_jButton10ActionPerformed

    private void jList1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList1MouseClicked

        try {
            String select_name = jList1.getSelectedValue();
            String sql = "select * from employeeInfo where fname = ?";
            pst = con.prepareStatement(sql);
            pst.setString(1, select_name);
            rs = pst.executeQuery();
            if (rs.next()) {
                String add1 = rs.getString("employee_id");
                EI_txt.setText(add1);
                String add2 = rs.getString("civilRegistry");
                CR_txt.setText(add2);
                String add3 = rs.getString("fname");
                fname_txt.setText(add3);
                String add4 = rs.getString("lname");
                lname_txt1.setText(add4);
                String add5 = rs.getString("age");
                combo_age.setSelectedItem(add5);
                String add6 = rs.getString("email");
                email_txt.setText(add6);
                String add7 = rs.getString("mobileNum");
                mobileNum_txt.setText(add7);
                String add8 = rs.getString("telephoneNum");
                telephoneNum_txt.setText(add8);
                String add9 = rs.getString("gender");
                if (add9.equals("male")) {
                    radioButton_male.setSelected(true);
                } else if (add9.equals("female")) {
                    radioButton_female.setSelected(true);
                }
                String add10 = rs.getString("date");
                ((JTextField) date_chooser.getDateEditor().getUiComponent()).setText(add10);
                String add11 = rs.getString("socialStatus");
                if (add11.equals("unmarried")) {
                    combo_sotial.setSelectedIndex(0);
                } else if (add11.equals("married")) {
                    combo_sotial.setSelectedIndex(1);
                } else if (add11.equals("separated")) {
                    combo_sotial.setSelectedIndex(2);
                } else if (add11.equals("widowed")) {
                    combo_sotial.setSelectedIndex(3);
                }
                String add12 = rs.getString("nationality");
                nationality_txt.setText(add12);
                String add13 = rs.getString("address");
                address_txt.setText(add13);
                String add14 = rs.getString("qualification");
                if (add14.equals("Certificate of Secondary Education")) {
                    combo_qualification.setSelectedIndex(1);
                } else if (add14.equals("Bachelor")) {
                    combo_qualification.setSelectedIndex(2);
                }
                combo_qualification.setSelectedItem(add14);
                String add15 = rs.getString("DICE");
                if (add15.equals("excellent")) {
                    checkBox_1.setSelected(true);
                } else if (add15.equals("good")) {
                    checkBox_2.setSelected(true);
                } else if (add15.equals("average")) {
                    checkBox_3.setSelected(true);
                } else if (add15.equals("weak")) {
                    checkBox_4.setSelected(true);
                }

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            try {
                pst.close();
                rs.close();

            } catch (SQLException ex) {
                Logger.getLogger(Management.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }


    }//GEN-LAST:event_jList1MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        MessageFormat header = new MessageFormat("Employee Information");
        MessageFormat footer = new MessageFormat("page{0,number,integer}");

        try {
            table_employee.print(JTable.PrintMode.NORMAL, header, footer);
        } catch (java.awt.print.PrinterException e) {
            System.err.format("can not print %s%n", e.getMessage());
        }

    }//GEN-LAST:event_jButton3ActionPerformed

    private void combo_orderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_combo_orderMouseClicked

    }//GEN-LAST:event_combo_orderMouseClicked

    private void combo_orderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_orderActionPerformed

        int select = combo_order.getSelectedIndex();
        if (select == 0) {
            try {
                String sql = "select employee_id as 'رقم الموظف' , civilRegistry as 'السجل المدني' ,fname as 'الآسم الاول' ,"
                        + "lname as 'الآسم الثاني', age as 'العمر' , email as 'البريد الألكتروني' , mobileNum as 'رقم الجوال' ,"
                        + "telephoneNum as 'رق الهاتف' , gender as 'الجنس' , date as 'تآريخ الميلاد' , socialStatus as 'الحالة الأجتماعية' ,"
                        + "nationality as 'الجنسية' , address as 'العنوان' , qualification as 'الدرجة العلمية' ,"
                        + "DICE as 'درجة إجادة آستخدام الحاسوب ' from employeeInfo order by employee_id ";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                table_employee.setModel(DbUtils.resultSetToTableModel(rs));
                pst.close();
                rs.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            } finally {
                try {
                    pst.close();
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Management.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else if (select == 1) {
            try {
                String sql = "select employee_id as 'رقم الموظف' , civilRegistry as 'السجل المدني' ,fname as 'الآسم الاول' ,"
                        + "lname as 'الآسم الثاني', age as 'العمر' , email as 'البريد الألكتروني' , mobileNum as 'رقم الجوال' ,"
                        + "telephoneNum as 'رق الهاتف' , gender as 'الجنس' , date as 'تآريخ الميلاد' , socialStatus as 'الحالة الأجتماعية' ,"
                        + "nationality as 'الجنسية' , address as 'العنوان' , qualification as 'الدرجة العلمية' ,"
                        + "DICE as 'درجة إجادة آستخدام الحاسوب ' from employeeInfo order by  employee_id desc";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                table_employee.setModel(DbUtils.resultSetToTableModel(rs));
                pst.close();
                rs.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            } finally {
                try {
                    pst.close();
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Management.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        } else if (select == 2) {
            try {
                String sql = "select employee_id as 'رقم الموظف' , civilRegistry as 'السجل المدني' ,fname as 'الآسم الاول' ,"
                        + "lname as 'الآسم الثاني', age as 'العمر' , email as 'البريد الألكتروني' , mobileNum as 'رقم الجوال' ,"
                        + "telephoneNum as 'رق الهاتف' , gender as 'الجنس' , date as 'تآريخ الميلاد' , socialStatus as 'الحالة الأجتماعية' ,"
                        + "nationality as 'الجنسية' , address as 'العنوان' , qualification as 'الدرجة العلمية' ,"
                        + "DICE as 'درجة إجادة آستخدام الحاسوب ' from employeeInfo order by fname";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                table_employee.setModel(DbUtils.resultSetToTableModel(rs));
                pst.close();
                rs.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            } finally {
                try {
                    pst.close();
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Management.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        } else if (select == 3) {
            try {
                String sql = "select employee_id as 'رقم الموظف' , civilRegistry as 'السجل المدني' ,fname as 'الآسم الاول' ,"
                        + "lname as 'الآسم الثاني', age as 'العمر' , email as 'البريد الألكتروني' , mobileNum as 'رقم الجوال' ,"
                        + "telephoneNum as 'رق الهاتف' , gender as 'الجنس' , date as 'تآريخ الميلاد' , socialStatus as 'الحالة الأجتماعية' ,"
                        + "nationality as 'الجنسية' , address as 'العنوان' , qualification as 'الدرجة العلمية' ,"
                        + "DICE as 'درجة إجادة آستخدام الحاسوب ' from employeeInfo order by age";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                table_employee.setModel(DbUtils.resultSetToTableModel(rs));
                pst.close();
                rs.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            } finally {
                try {
                    pst.close();
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Management.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
    }//GEN-LAST:event_combo_orderActionPerformed

    private void combo_chartTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_chartTypeActionPerformed
        int select = combo_chartType.getSelectedIndex();
        if (select == 0) {
            // combo_foodTime.setVisible(true);
            combo_food.setVisible(true);
            jPanel_time.setVisible(false);
        } else if (select == 1) {
            combo_food.setVisible(false);
            search_year1.setSelected(false);
        }
    }//GEN-LAST:event_combo_chartTypeActionPerformed

    private void pie_chartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pie_chartActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pie_chartActionPerformed

    private void combo_month2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_month2ActionPerformed

    }//GEN-LAST:event_combo_month2ActionPerformed

    private void search_year1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search_year1ActionPerformed
        if (combo_chartType.getSelectedIndex() == 1) {
            jPanel_time.setVisible(true);
        }
    }//GEN-LAST:event_search_year1ActionPerformed

    private void search_monthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search_monthActionPerformed
        //search_day.setSelected(false);
    }//GEN-LAST:event_search_monthActionPerformed

    private void search_monthMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_search_monthMouseClicked

    }//GEN-LAST:event_search_monthMouseClicked

    private void s_yearKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_s_yearKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_s_yearKeyTyped

    private void s_monthKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_s_monthKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_s_monthKeyTyped

    private void s_dayKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_s_dayKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_s_dayKeyTyped

    private void year_txtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_year_txtKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_year_txtKeyTyped

    private void txt_year1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_year1KeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_txt_year1KeyTyped

    private void radio_invoiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radio_invoiceActionPerformed
        update_table3();
        panel_search1.setVisible(false);
        jTabbedPane1.setSelectedIndex(1);
    }//GEN-LAST:event_radio_invoiceActionPerformed

    private void user_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_user_tableMouseClicked

        int select_row = user_table.getSelectedRow();
        String click = user_table.getModel().getValueAt(select_row, 0).toString();
        try {
            String sql = "select * from userInfo where fname = '" + click + "' ";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();

            if (rs.next()) {
                String add1 = rs.getString("Fname");
                fanme_txt.setText(add1);
                String add2 = rs.getString("Lname");
                lname_txt.setText(add2);
                String add3 = rs.getString("email");
                mail_txt.setText(add3);
                String add4 = rs.getString("phoneNum");
                phone_txt.setText(add4);
                String add5 = rs.getString("password");
                pass_txt.setText(add5);
                String add6 = rs.getString("gender");
                if (add6.equals("male")) {
                    rad_male.setSelected(true);
                } else if (add6.equals("female")) {
                    rad_female.setSelected(true);
                }
                String add7 = rs.getString("date");
                ((JTextField) (date_choser.getDateEditor().getUiComponent())).setText(add7);
                String add8 = rs.getString("age");
                age_txt.setText(add8);
                String add9 = rs.getString("calories");
                cal_txt.setText(add9);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            try {
                pst.close();
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(Management.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_user_tableMouseClicked

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed

        try {
            String edit1 = fanme_txt.getText();
            String edit2 = lname_txt.getText();
            String edit3 = mail_txt.getText();
            String edit4 = phone_txt.getText();
            String edit5 = pass_txt.getText();
            String edit6 = "";
            if (rad_male.isSelected()) {
                edit6 = "male";
            } else if (rad_female.isSelected()) {
                edit6 = "female";
            }
            String edit7 = ((JTextField) date_choser.getDateEditor().getUiComponent()).getText();

            String edit8 = cal_txt.getText();
            String edit9 = age_txt.getText();

            String sql = "update userInfo set Fname = '" + edit1 + "' , Lname = '" + edit2 + "' ,  email = '" + edit3 + "'  , "
                    + "phoneNum = '" + edit4 + "' ,  password = '" + edit5 + "' , gender ='" + edit6 + "' , date = '" + edit7 + "' , "
                    + "calories = '" + edit8 + "' , age = '" + edit9 + "' where Fname = '" + edit1 + "'  ";
            pst = con.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "تم تحديث البيانات بنجاح", "تحديث البيانات", JOptionPane.OK_OPTION);
            pst.close();
            update_table3();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            try {
                pst.close();

            } catch (SQLException ex) {
                Logger.getLogger(Management.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton13ActionPerformed

    private void rad_maleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rad_maleActionPerformed
        gender1 = "male";
    }//GEN-LAST:event_rad_maleActionPerformed

    private void rad_femaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rad_femaleActionPerformed
        gender1 = "female";
    }//GEN-LAST:event_rad_femaleActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed

        int select = user_table.getSelectedRow();
        String clicke = user_table.getModel().getValueAt(select, 0).toString();
        try {
            String sql = " delete from userInfo where Fname = '" + clicke + "' ";

            pst = con.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "تم حذف البيانات بنجاح", "حذف بيانات موظف ", JOptionPane.CLOSED_OPTION);
            pst.close();

            update_table3();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            try {
                pst.close();

            } catch (SQLException ex) {
                Logger.getLogger(Management.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed

        MessageFormat header = new MessageFormat("Users Information");
        MessageFormat footer = new MessageFormat("page {0,number,integer}");

        try {
            user_table.print(JTable.PrintMode.NORMAL, header, footer);

        } catch (PrinterException e) {
            System.err.format("can not print %s%n", e.getMessage());
        }
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        new UserInfo().setVisible(true);
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        update_table3();
    }//GEN-LAST:event_jButton18ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed

        String fname = fanme_txt.getText();
        String lname = lname_txt.getText();
        String email = mail_txt.getText();
        String phone = phone_txt.getText();
        String pass = pass_txt.getText();
        String gender = "";
        if (rad_male.isSelected()) {
            gender = "male";
        } else if (rad_female.isSelected()) {
            gender = "female";
        }
        String date = ((JTextField) date_choser.getDateEditor().getUiComponent()).getText();
        String cal = cal_txt.getText();
        String age = age_txt.getText();
        try {
            Document doc = new Document();
            PdfWriter.getInstance(doc, new FileOutputStream("user information.pdf"));
            doc.open();

            Image image = Image.getInstance("Picture1.png");
            doc.add(image);

            doc.add(new Paragraph("                           The Best Food", FontFactory.getFont(FontFactory.TIMES_ITALIC, 24, Font.BOLD, BaseColor.DARK_GRAY)));
            doc.add(new Paragraph("          ___________________________________________________________________\n"));
            doc.add(new Paragraph("                                                                 "));

            PdfPTable table = new PdfPTable(2);
            PdfPCell titel = new PdfPCell(new Paragraph("user Information", FontFactory.getFont(FontFactory.TIMES_ITALIC, 20, Font.BOLD, BaseColor.DARK_GRAY)));
            titel.setColspan(2);
            titel.setHorizontalAlignment(Element.ALIGN_CENTER);
            titel.setBackgroundColor(BaseColor.LIGHT_GRAY);
            table.addCell(titel);

            table.addCell("First name");
            table.addCell(fname);
            table.addCell("Last name");
            table.addCell(lname);
            table.addCell("email");
            table.addCell(email);
            table.addCell("Phone number");
            table.addCell(phone);
            table.addCell("Password");
            table.addCell(pass);
            table.addCell("Gender");
            table.addCell(gender);
            table.addCell("Date");
            table.addCell(date);
            table.addCell("Calories");
            table.addCell(cal);
            table.addCell("Age");
            table.addCell(age);

            doc.add(table);

            doc.close();
            JOptionPane.showMessageDialog(null, "تم حفظ الملف بنجاح");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }//GEN-LAST:event_jButton17ActionPerformed

    private void year_txt2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_year_txt2KeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_year_txt2KeyTyped

    private void search_month2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_search_month2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_search_month2MouseClicked

    private void search_month2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search_month2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_search_month2ActionPerformed

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed

        jTabbedPane1.setSelectedIndex(1);
        update_table3();
        DefaultTableModel model = (DefaultTableModel) user_table.getModel();

        if (search_date1.isSelected()) {
            model.setRowCount(0);
            int day1 = Integer.parseInt(s_day1.getText());
            int month1 = Integer.parseInt(s_month1.getText());
            int year1 = Integer.parseInt(s_year1.getText());
            String date = "" + day1 + "/" + month1 + "/" + year1 + "";

            try {

                String sql = "select * from userInfo where datee = ? ";

                pst = con.prepareStatement(sql);
                pst.setString(1, date);
                rs = pst.executeQuery();

                DefaultTableModel model2 = (DefaultTableModel) user_table.getModel();
                Vector<Object> rows;

                while (rs.next()) {
                    rows = new Vector<Object>();

                    rows.add(rs.getString("Fname"));
                    rows.add(rs.getString("Lname"));
                    rows.add(rs.getString("email"));
                    rows.add(rs.getString("phoneNum"));
                    rows.add(rs.getString("password"));
                    rows.add(rs.getString("gender"));
                    rows.add(rs.getString("calories"));
                    rows.add(rs.getString("date"));
                    rows.add(rs.getString("age"));
                    rows.add(rs.getString("day"));
                    rows.add(rs.getString("month"));
                    rows.add(rs.getString("year"));
                    rows.add(rs.getString("datee"));
                    rows.add(rs.getString("time"));

                    model.addRow(rows);
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            } finally {
                try {
                    pst.close();
                    rs.close();

                } catch (SQLException ex) {
                    Logger.getLogger(Management.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
            }

        } else if (search_month2.isSelected()) {
            model.setRowCount(0);
            String month = combo_month3.getSelectedItem().toString();
            String year = s_year2.getText();
            try {

                String sql = "select * from userInfo where month = ? and year = ? ";

                pst = con.prepareStatement(sql);
                pst.setString(1, month);
                pst.setString(2, year);
                rs = pst.executeQuery();

                DefaultTableModel model2 = (DefaultTableModel) user_table.getModel();
                Vector<Object> rows;

                while (rs.next()) {
                    rows = new Vector<Object>();

                    rows.add(rs.getString("Fname"));
                    rows.add(rs.getString("Lname"));
                    rows.add(rs.getString("email"));
                    rows.add(rs.getString("phoneNum"));
                    rows.add(rs.getString("password"));
                    rows.add(rs.getString("gender"));
                    rows.add(rs.getString("calories"));
                    rows.add(rs.getString("date"));
                    rows.add(rs.getString("age"));
                    rows.add(rs.getString("day"));
                    rows.add(rs.getString("month"));
                    rows.add(rs.getString("year"));
                    rows.add(rs.getString("datee"));
                    rows.add(rs.getString("time"));

                    model.addRow(rows);
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            } finally {
                try {
                    pst.close();
                    rs.close();

                } catch (SQLException ex) {
                    Logger.getLogger(Management.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
            }

        } else if (search_year2.isSelected()) {
            model.setRowCount(0);
            String year = year_txt2.getText();
            try {

                String sql = "select * from userInfo where year = ? ";

                pst = con.prepareStatement(sql);
                pst.setString(1, year);
                rs = pst.executeQuery();

                DefaultTableModel model2 = (DefaultTableModel) user_table.getModel();
                Vector<Object> rows;

                while (rs.next()) {
                    rows = new Vector<Object>();

                    rows.add(rs.getString("Fname"));
                    rows.add(rs.getString("Lname"));
                    rows.add(rs.getString("email"));
                    rows.add(rs.getString("phoneNum"));
                    rows.add(rs.getString("password"));
                    rows.add(rs.getString("gender"));
                    rows.add(rs.getString("calories"));
                    rows.add(rs.getString("date"));
                    rows.add(rs.getString("age"));
                    rows.add(rs.getString("day"));
                    rows.add(rs.getString("month"));
                    rows.add(rs.getString("year"));
                    rows.add(rs.getString("datee"));
                    rows.add(rs.getString("time"));

                    model.addRow(rows);
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            } finally {
                try {
                    pst.close();
                    rs.close();

                } catch (SQLException ex) {
                    Logger.getLogger(Management.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
            }

        }


    }//GEN-LAST:event_jButton20ActionPerformed

    private void s_year1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_s_year1KeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_s_year1KeyTyped

    private void s_month1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_s_month1KeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_s_month1KeyTyped

    private void s_day1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_s_day1KeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_s_day1KeyTyped

    private void combo_printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_printActionPerformed

        int select = combo_print.getSelectedIndex();
        if (select == 0) {

            MessageFormat header = new MessageFormat("Invoice Information");
            MessageFormat footer = new MessageFormat("The best food       page{0,number,integer}");

            try {
                table_invoice.print(JTable.PrintMode.NORMAL, header, footer);

                JOptionPane.showMessageDialog(null, "Done");
            } catch (PrinterException e) {
                JOptionPane.showMessageDialog(null, e);
            }
        } else if (select == 1) {

            String id = id_txt.getText();
            String name = Ename_txt.getText();
            String total = sum_txt.getText();
            String day = day_txt.getText();
            String month = month_txt.getText();
            String year = year2_txt.getText();
            String date = date_txt.getText();
            String time = time_txt.getText();

            try {
                Document doc = new Document();
                PdfWriter.getInstance(doc, new FileOutputStream("invoice.pdf"));
                doc.open();

                Image image = Image.getInstance("Picture1.png");
                doc.add(image);

                doc.add(new Paragraph("                      The Best Food", FontFactory.getFont(FontFactory.TIMES_ITALIC, 24, Font.BOLD, BaseColor.DARK_GRAY)));
                doc.add(new Paragraph("          ___________________________________________________________________\n"));
                doc.add(new Paragraph("                                                                 "));
                PdfPTable table = new PdfPTable(2);
                PdfPCell titel = new PdfPCell(new Paragraph("Invoice Information", FontFactory.getFont(FontFactory.TIMES_ITALIC, 18, Font.BOLD, BaseColor.DARK_GRAY)));
                titel.setColspan(2);
                titel.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(titel);

                table.addCell("Inoice number");
                table.addCell(id);
                table.addCell("Employee name");
                table.addCell(name);
                table.addCell("Total");
                table.addCell(total);
                table.addCell("Day");
                table.addCell(day);
                table.addCell("Month");
                table.addCell(month);
                table.addCell("Year");
                table.addCell(year);
                table.addCell("Date");
                table.addCell(date);
                table.addCell("Time");
                table.addCell(time);

                doc.add(table);

                doc.close();
                JOptionPane.showMessageDialog(null, "تم حفظ المجلد بصيغة PDF");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }

        }
    }//GEN-LAST:event_combo_printActionPerformed

    private void jButton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton22ActionPerformed
        jPanel8.setVisible(true);
        jCheckBox4.setSelected(false);
    }//GEN-LAST:event_jButton22ActionPerformed

    private void table_invoiceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_invoiceMouseClicked
        int select = table_invoice.getSelectedRow();
        String click = table_invoice.getModel().getValueAt(select, 0).toString();
        String time = table_invoice.getModel().getValueAt(select, 7).toString();
        try {
            String sql = "select * from invoices where invoice_id = '" + click + "' and time = '" + time + "'  ";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();

            if (rs.next()) {
                String add1 = rs.getString("invoice_id");
                id_txt.setText(add1);
                String add2 = rs.getString("employee_name");
                Ename_txt.setText(add2);
                String add3 = rs.getString("total");
                sum_txt.setText(add3);
                String add4 = rs.getString("day");
                day_txt.setText(add4);
                String add5 = rs.getString("month");
                month_txt.setText(add5);
                String add6 = rs.getString("year");
                year2_txt.setText(add6);
                String add7 = rs.getString("date");
                date_txt.setText(add7);
                String add8 = rs.getString("time");
                time_txt.setText(add8);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            try {
                pst.close();
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(Management.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_table_invoiceMouseClicked

    private void combo_month4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_month4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combo_month4ActionPerformed

    private void jButton25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton25ActionPerformed

        if (check_date.isSelected()) {
            int day1 = Integer.parseInt(day_now1.getText());
            int month1 = Integer.parseInt(month_now1.getText());
            int year1 = Integer.parseInt(year_now1.getText());
            String date = "" + day1 + "/" + month1 + "/" + year1 + "";
            double sum = select_day_total(date);
            lable_date.setText(sum + " SAR");
        } else if (check_month.isSelected()) {
            String month = combo_month4.getSelectedItem().toString();
            String year_month = year_now2.getText();
            double sum = select_month_total(month, year_month);
            lable_month.setText(sum + " SAR");
        } else if (check_year.isSelected()) {
            String year = year_now3.getText();
            double sum = select_year_total(year);
            lable_year.setText(sum + " SAR");
        }
    }//GEN-LAST:event_jButton25ActionPerformed

    private void year_now2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_year_now2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_year_now2ActionPerformed

    private void search_day1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search_day1ActionPerformed
        jPanel_time.setVisible(false);
    }//GEN-LAST:event_search_day1ActionPerformed

    private void search_month1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search_month1ActionPerformed
        jPanel_time.setVisible(false);
    }//GEN-LAST:event_search_month1ActionPerformed

    private void select_dayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_select_dayActionPerformed

    }//GEN-LAST:event_select_dayActionPerformed

    private void select_monthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_select_monthActionPerformed

    }//GEN-LAST:event_select_monthActionPerformed

    private void select_yearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_select_yearActionPerformed

    }//GEN-LAST:event_select_yearActionPerformed

    private void jCheckBox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox4ActionPerformed
        jPanel8.setVisible(false);
    }//GEN-LAST:event_jCheckBox4ActionPerformed

    private void s_year2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_s_year2KeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_s_year2KeyTyped

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
        panel_search1.setVisible(true);
        jCheckBox7.setSelected(false);
    }//GEN-LAST:event_jButton19ActionPerformed

    private void jCheckBox7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox7ActionPerformed
        panel_search1.setVisible(false);
    }//GEN-LAST:event_jCheckBox7ActionPerformed

    private void year_txt3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_year_txt3KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_year_txt3KeyTyped

    private void search_txtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search_txtKeyPressed

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            DefaultTableModel model = (DefaultTableModel) table_employee.getModel();
            model.setRowCount(0);
            try {
                String sql = "select * from employeeInfo where employee_id = ? or mobileNum = ? or age = ? ";
                pst = con.prepareStatement(sql);
                pst.setString(1, search_txt.getText());
                pst.setString(2, search_txt.getText());
                pst.setString(3, search_txt.getText());
                rs = pst.executeQuery();
                Vector<Object> rows;
                while (rs.next()) {
                    rows = new Vector<Object>();

                    rows.add(rs.getString("employee_id"));
                    rows.add(rs.getString("civilRegistry"));
                    rows.add(rs.getString("fname"));
                    rows.add(rs.getString("lname"));
                    rows.add(rs.getString("age"));
                    rows.add(rs.getString("email"));
                    rows.add(rs.getString("mobileNum"));
                    rows.add(rs.getString("telephoneNum"));
                    rows.add(rs.getString("gender"));
                    rows.add(rs.getString("date"));
                    rows.add(rs.getString("socialStatus"));
                    rows.add(rs.getString("nationality"));
                    rows.add(rs.getString("address"));
                    rows.add(rs.getString("qualification"));
                    rows.add(rs.getString("DICE"));

                    model.addRow(rows);

                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            } finally {
                try {
                    pst.close();
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Management.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_search_txtKeyPressed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        int p = JOptionPane.showConfirmDialog(null, "هل ترغب في تآكيد الطلب ؟", "حذف بيانات عمل موظف ", JOptionPane.YES_NO_OPTION);
        if (p == 0) {
            int select_row = table_employee.getSelectedRow();
            String click = table_employee.getModel().getValueAt(select_row, 0).toString();
            String date = table_employee.getModel().getValueAt(select_row, 7).toString();
            try {
                String sql = "delete from employeeWork where employee_id = '" + click + "'and date = '" + date + "'  ";
                pst = con.prepareStatement(sql);
                pst.execute();

                JOptionPane.showMessageDialog(null, "تم حذف البيانات بنجاح", "حذف بيانات عمل موظف ", JOptionPane.CLOSED_OPTION);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            } finally {
                try {
                    pst.close();
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Management.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            update_table1();
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jCheckBox9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox9ActionPerformed
        panel_search.setVisible(false);
    }//GEN-LAST:event_jCheckBox9ActionPerformed

    private void search_txt1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search_txt1KeyPressed

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {

            DefaultTableModel model = (DefaultTableModel) user_table.getModel();
            model.setRowCount(0);

            try {
                String sql = "select * from userInfo where Fname = ? or phoneNum = ? or age = ? ";
                pst = con.prepareStatement(sql);
                pst.setString(1, search_txt1.getText());
                pst.setString(2, search_txt1.getText());
                pst.setString(3, search_txt1.getText());
                rs = pst.executeQuery();

                Vector<Object> rows;

                while (rs.next()) {
                    rows = new Vector<Object>();

                    rows.add(rs.getString("Fname"));
                    rows.add(rs.getString("Lname"));
                    rows.add(rs.getString("email"));
                    rows.add(rs.getString("phoneNum"));
                    rows.add(rs.getString("password"));
                    rows.add(rs.getString("gender"));
                    rows.add(rs.getString("date"));
                    rows.add(rs.getString("calories"));
                    rows.add(rs.getString("age"));
                    rows.add(rs.getString("day"));
                    rows.add(rs.getString("month"));
                    rows.add(rs.getString("year"));
                    rows.add(rs.getString("datee"));
                    rows.add(rs.getString("time"));

                    model.addRow(rows);
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            } finally {
                try {
                    pst.close();
                    rs.close();

                } catch (SQLException ex) {
                    Logger.getLogger(Management.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
    }//GEN-LAST:event_search_txt1KeyPressed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        int select = table_invoice.getSelectedRow();
        try {
            String invoice_id = table_invoice.getModel().getValueAt(select, 0).toString();
            String date = table_invoice.getModel().getValueAt(select, 6).toString();

            String sql = "delete from invoices where invoice_id = '" + invoice_id + "' and date = '" + date + "'  ";
            pst = con.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "تم حذف البيانات بنجاح", "حذف بيانات فاتورة ", JOptionPane.CLOSED_OPTION);
            pst.close();
            update_table2();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            try {
                pst.close();

            } catch (SQLException ex) {
                Logger.getLogger(Management.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton12ActionPerformed

    private void telephoneNum_txtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_telephoneNum_txtKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_telephoneNum_txtKeyTyped

    private void mobileNum_txtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mobileNum_txtKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_mobileNum_txtKeyTyped

    private void phone_txtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_phone_txtKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_phone_txtKeyTyped

    private void age_txtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_age_txtKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_age_txtKeyTyped

    private void cal_txtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cal_txtKeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || c == '.')) {
            evt.consume();
        }
    }//GEN-LAST:event_cal_txtKeyTyped

    private void year_now4KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_year_now4KeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_year_now4KeyTyped

    private void month_now2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_month_now2KeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_month_now2KeyTyped

    private void day_now2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_day_now2KeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_day_now2KeyTyped

    private void year_now5KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_year_now5KeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_year_now5KeyTyped

    private void day_nowKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_day_nowKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_day_nowKeyTyped

    private void month_nowKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_month_nowKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_month_nowKeyTyped

    private void year_nowKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_year_nowKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_year_nowKeyTyped

    private void month_yearKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_month_yearKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_month_yearKeyTyped

    private void year_txt1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_year_txt1KeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_year_txt1KeyTyped

    private void day_now1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_day_now1KeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_day_now1KeyTyped

    private void month_now1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_month_now1KeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_month_now1KeyTyped

    private void year_now1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_year_now1KeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_year_now1KeyTyped

    private void year_now2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_year_now2KeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_year_now2KeyTyped

    private void year_now3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_year_now3KeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_year_now3KeyTyped

    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked
     int select =jTabbedPane1.getSelectedIndex();
     if (select == 2){
        search_day1.setSelected(false);
        search_month1.setSelected(false);
        search_year1.setSelected(false);
     }
    }//GEN-LAST:event_jTabbedPane1MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Mac OS X".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Management.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Management.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Management.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Management.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Management().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField CR_txt;
    private javax.swing.JTextField EI_txt;
    private javax.swing.JTextField Ename_txt;
    private javax.swing.JTextField address_txt;
    private javax.swing.JTextField age_txt;
    private javax.swing.JCheckBox bar_chart;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup10;
    private javax.swing.ButtonGroup buttonGroup11;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.ButtonGroup buttonGroup5;
    private javax.swing.ButtonGroup buttonGroup6;
    private javax.swing.ButtonGroup buttonGroup7;
    private javax.swing.ButtonGroup buttonGroup8;
    private javax.swing.ButtonGroup buttonGroup9;
    private javax.swing.JTextField cal_txt;
    private javax.swing.JCheckBox checkBox_1;
    private javax.swing.JCheckBox checkBox_2;
    private javax.swing.JCheckBox checkBox_3;
    private javax.swing.JCheckBox checkBox_4;
    private javax.swing.JCheckBox check_date;
    private javax.swing.JCheckBox check_month;
    private javax.swing.JCheckBox check_year;
    private javax.swing.JComboBox<String> combo_age;
    private javax.swing.JComboBox<String> combo_chartType;
    private javax.swing.JComboBox<String> combo_food;
    private javax.swing.JPanel combo_foodTime;
    private javax.swing.JComboBox<String> combo_month;
    private javax.swing.JComboBox<String> combo_month1;
    private javax.swing.JComboBox<String> combo_month2;
    private javax.swing.JComboBox<String> combo_month3;
    private javax.swing.JComboBox<String> combo_month4;
    private javax.swing.JComboBox<String> combo_order;
    private javax.swing.JComboBox<String> combo_print;
    private javax.swing.JComboBox<String> combo_qualification;
    private javax.swing.JComboBox<String> combo_sotial;
    private com.toedter.calendar.JDateChooser date_chooser;
    private com.toedter.calendar.JDateChooser date_choser;
    private javax.swing.JTextField date_txt;
    private javax.swing.JTextField day_now;
    private javax.swing.JTextField day_now1;
    private javax.swing.JTextField day_now2;
    private javax.swing.JTextField day_txt;
    private javax.swing.JCheckBox dayes;
    private javax.swing.JTextField email_txt;
    private javax.swing.JRadioButton employee_work;
    private javax.swing.JTextField fanme_txt;
    private javax.swing.JTextField fname_txt;
    private javax.swing.JTextField id_txt;
    private javax.swing.JRadioButton invoices;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton25;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JCheckBox jCheckBox7;
    private javax.swing.JCheckBox jCheckBox9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel111;
    private javax.swing.JLabel jLabel112;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel_time;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel label_date;
    private javax.swing.JLabel label_time;
    private javax.swing.JLabel lable_date;
    private javax.swing.JLabel lable_month;
    private javax.swing.JLabel lable_year;
    private javax.swing.JCheckBox line_chart;
    private javax.swing.JTextField lname_txt;
    private javax.swing.JTextField lname_txt1;
    private javax.swing.JTextField mail_txt;
    private javax.swing.JTextField mobileNum_txt;
    private javax.swing.JTextField month_now;
    private javax.swing.JTextField month_now1;
    private javax.swing.JTextField month_now2;
    private javax.swing.JTextField month_txt;
    private javax.swing.JTextField month_year;
    private javax.swing.JCheckBox months;
    private javax.swing.JTextField nationality_txt;
    private javax.swing.JPanel panel_search;
    private javax.swing.JPanel panel_search1;
    private javax.swing.JTextField pass_txt;
    private javax.swing.JTextField phone_txt;
    private javax.swing.JCheckBox pie_chart;
    private javax.swing.JRadioButton rad_employeeIngo;
    private javax.swing.JRadioButton rad_female;
    private javax.swing.JRadioButton rad_male;
    private javax.swing.JRadioButton rad_save;
    private javax.swing.JRadioButton radioButton_female;
    private javax.swing.JRadioButton radioButton_male;
    private javax.swing.JRadioButton radio_invoice;
    private javax.swing.JTextField s_day;
    private javax.swing.JTextField s_day1;
    private javax.swing.JTextField s_month;
    private javax.swing.JTextField s_month1;
    private javax.swing.JTextField s_year;
    private javax.swing.JTextField s_year1;
    private javax.swing.JTextField s_year2;
    private javax.swing.JCheckBox search_date;
    private javax.swing.JCheckBox search_date1;
    private javax.swing.JCheckBox search_day1;
    private javax.swing.JCheckBox search_month;
    private javax.swing.JCheckBox search_month1;
    private javax.swing.JCheckBox search_month2;
    private javax.swing.JTextField search_txt;
    private javax.swing.JTextField search_txt1;
    private javax.swing.JCheckBox search_year;
    private javax.swing.JCheckBox search_year1;
    private javax.swing.JCheckBox search_year2;
    private javax.swing.JCheckBox select_day;
    private javax.swing.JCheckBox select_month;
    private javax.swing.JCheckBox select_year;
    private javax.swing.JTextField sum_txt;
    private javax.swing.JTable table_employee;
    private javax.swing.JTable table_invoice;
    private javax.swing.JTextField telephoneNum_txt;
    private javax.swing.JTextField time_txt;
    private javax.swing.JTextField txt_year1;
    private javax.swing.JTable user_table;
    private javax.swing.JTextField year2_txt;
    private javax.swing.JTextField year_now;
    private javax.swing.JTextField year_now1;
    private javax.swing.JTextField year_now2;
    private javax.swing.JTextField year_now3;
    private javax.swing.JTextField year_now4;
    private javax.swing.JTextField year_now5;
    private javax.swing.JTextField year_txt;
    private javax.swing.JTextField year_txt1;
    private javax.swing.JTextField year_txt2;
    private javax.swing.JTextField year_txt3;
    // End of variables declaration//GEN-END:variables
    private String gender;
    private String DICE;
    private String sotial;
    private String edu;
    private String gender1;

}
