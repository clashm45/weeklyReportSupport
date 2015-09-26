package wrs.control;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import wrs.model.WeeklyReport;

@ViewScoped
@ManagedBean
public class EditorController {

	private WeeklyReport report = new WeeklyReport();
	
	/**
	 * 週報を保存して参照画面に遷移する
	 * @return 参照画面
	 */
	public String save() {
		Charset charset = StandardCharsets.UTF_8;
		try {
			Files.createDirectories(Paths.get("report"));
			
			Path output = Paths.get("report", report.getTitle()+".txt");
			System.out.println(output.toAbsolutePath().toString());
			Files.write(output,
					report.getContent().getBytes(charset),
					StandardOpenOption.CREATE_NEW, StandardOpenOption.WRITE);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public WeeklyReport getReport() {
		return report;
	}

	public void setReport(WeeklyReport report) {
		this.report = report;
	}
	
}
