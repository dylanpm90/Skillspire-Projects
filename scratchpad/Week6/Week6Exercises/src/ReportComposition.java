import java.util.*;

public class ReportComposition {

    class Report{
        private ReportList reportList = new ReportList();

        void addToReportList(String listItem){
            this.reportList = reportList;
            reportList.addToReportList(listItem);
        }
        int reportListSize(ReportList reportList){
            this.reportList = reportList;
            int reportListSize = reportList.listSize;
            return reportListSize;
        }
    }

    class ReportList{
        String listItem;

        List<String> list = new ArrayList<>();
        int listSize = list.size();

        void addToReportList(String listItem){
            this.listItem = listItem;
            list.add(listItem);
        }
    }

    void main(String[] args) {
        Report report1 = new Report();
        report1.addToReportList("Laptop");

        System.out.println(report1.reportList.listItem);
    }
}
