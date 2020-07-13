
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import model.dao.apt_charterRateDao;
import model.dao.apt_riseRateDao;
import model.dto.apt_charterRate;
import model.dto.apt_riseRate;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class main {

    static apt_charterRateDao acrDao = new apt_charterRateDao();
    static apt_riseRateDao arrDao = new apt_riseRateDao();

    public static void main(String args[]) throws SQLException {




        getArr();
        //getAcr();


    }

    public static void getArr() throws SQLException {
        //이달 평균 3달평균 1년 평균
        for (int i = 1; i <= 3; i++) {
            int rank = 0;

            for (int j = 1; j <= 100; j++) {

                // Jsoup를 이용해서 http://www.cgv.co.kr/movies/ 크롤링
                String url = "http://buking.kr/rank.php?m=msp&st=md&gi=" + i +"&p=" +j; //크롤링할 url지정
                Document doc = null;        //Document에는 페이지의 전체 소스가 저장된다

                try {
                    doc = Jsoup.connect(url).get();
                } catch (IOException e) {
                    e.printStackTrace();
                    break;
                }

                //System.out.println(doc.toString());
                //select를 이용하여 원하는 태그를 선택한다. select는 원하는 값을 가져오기 위한 중요한 기능이다.
                Elements element = doc.select("#rlist");

                System.out.println("============================================================");


                //Iterator을 사용하여 하나씩 값 가져오기
                //Iterator<Element> ie2 = element.select("td.td2 ilink").iterator();
                Iterator<Element> ie1 = element.select("td.td2").iterator();
                Iterator<Element> ie2 = element.select("td.td2rp").iterator();
                Iterator<Element> ie3 = element.select("td.td2r").iterator();


                while (ie2.hasNext()){


                    /*
                    System.out.println((++rank) + "위 -  지역 : " + ie1.next().text());
                    System.out.println("아파트 : " + ie1.next().text());

                    String ie2_temp[] = ie2.next().text().split(" ");
                    String ie3_temp[] = ie3.next().text().split(" ");


                    System.out.println(ie2_temp[0] + " - " + ie2_temp[1]);
                    System.out.println(ie3_temp[0] + " - " + ie3_temp[1]);
                    */



                    String ie2_temp[] = ie2.next().text().split(" ");
                    String ie3_temp[] = ie3.next().text().split(" ");

                    //문자열 ▲ ▼

                    ie2_temp[1] = ie2_temp[1].replace("▲", "+");
                    ie2_temp[1] = ie2_temp[1].replace("▼", "-");

                    String bun = "" + i;
                    String location = ie1.next().text();
                    String name = ie1.next().text();
                    String ascent = ie2_temp[0];
                    String riseRate = ie2_temp[1];
                    String before_date = ie3_temp[0];
                    String now_date = ie3_temp[1];

                    System.out.println("분류 " + i);
                    System.out.println((++rank) + "위 -  지역 : " + location);
                    System.out.println("아파트 : " + name);
                    System.out.println(ascent + " " + riseRate);
                    System.out.println(before_date + " " + now_date);

                    apt_riseRate dto = new apt_riseRate(bun,""+rank,location,name,ascent,riseRate,before_date,now_date);
                    arrDao.saveRiseRate(dto);

                }

                System.out.println("============================================================");
            }
        }

    }


    public static void getAcr() throws SQLException {
        //이달 평균 3달평균 1년 평균
        for (int i = 1; i <= 3; i++) {
            int rank = 0;

            for (int j = 1; j <= 100; j++) {

                // Jsoup를 이용해서 http://www.cgv.co.kr/movies/ 크롤링
                String url = "http://buking.kr/rank.php?m=yp&st=yd&gi=" + i +"&p=" +j; //크롤링할 url지정
                Document doc = null;        //Document에는 페이지의 전체 소스가 저장된다

                try {
                    doc = Jsoup.connect(url).get();
                } catch (IOException e) {
                    e.printStackTrace();
                    break;
                }

                //System.out.println(doc.toString());
                //select를 이용하여 원하는 태그를 선택한다. select는 원하는 값을 가져오기 위한 중요한 기능이다.
                Elements element = doc.select("#rlist");

                System.out.println("============================================================");


                //Iterator을 사용하여 하나씩 값 가져오기
                //Iterator<Element> ie2 = element.select("td.td2 ilink").iterator();
                Iterator<Element> ie1 = element.select("td.td2").iterator();
                Iterator<Element> ie2 = element.select("td.td2rp").iterator();
                Iterator<Element> ie3 = element.select("td.td2r").iterator();


                while (ie2.hasNext()){

                    /*
                    System.out.println((++rank) + "위 -  지역 : " + ie1.next().text());
                    System.out.println("아파트 : " + ie1.next().text());

                    String ie2_temp[] = ie2.next().text().split(" ");
                    String ie3_temp[] = ie3.next().text().split(" ");

                    System.out.println(ie2_temp[0] + " - " + ie2_temp[1]);
                    System.out.println(ie3_temp[0] + " - " + ie3_temp[1]);

                    */

                    String ie2_temp[] = ie2.next().text().split(" ");
                    String ie3_temp[] = ie3.next().text().split(" ");


                    String bun = "" + i;
                    String location = ie1.next().text();
                    String name = ie1.next().text();
                    String apt_charterRate = ie2_temp[0];
                    String gap = ie2_temp[1];
                    String salePrice = ie3_temp[0];
                    String charter = ie3_temp[1];

                    System.out.println("분류 " + i);
                    System.out.println((++rank) + "위 -  지역 : " + location);
                    System.out.println("아파트 : " + name);
                    System.out.println(apt_charterRate + " " + gap);
                    System.out.println(salePrice + " " + charter);

                    apt_charterRate dto = new apt_charterRate(bun,""+rank,location,name,apt_charterRate,gap,salePrice,charter);
                    acrDao.saveCharterRate(dto);

                }

                System.out.println("============================================================");
            }
        }
    }
}

