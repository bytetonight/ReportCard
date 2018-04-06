package android.example.com.reportcard;


import android.example.com.reportcard.report.ReportCard;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView test = (TextView) findViewById(R.id.test);


        ReportCard report = new ReportCard("Random High School", 2100, "John Doe");
        report.addGradedSubject("Mathematics", "A");
        report.addGradedSubject("Physics", "B");
        report.addGradedSubject("History", "c");
        report.addGradedSubject("Geography", "d");
        report.addGradedSubject("English", "e");
        report.addGradedSubject("Sports", "z");

        test.setText(report.toString());
    }
}
