package pak;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class TicketBooking extends TagSupport {
	String tableName;
	String columnName;
	String trainno;
	String dbUrl;
	String driver;

	public String getDbUrl() {
		return dbUrl;
	}

	public void setDbUrl(String dbUrl) {
		this.dbUrl = dbUrl;
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String getTrainno() {
		return trainno;
	}

	public void setTrainno(String trainno) {
		this.trainno = trainno;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public int doStartTag() throws JspException {
		JspWriter out = pageContext.getOut();

		String query;
		try {
			Class.forName(driver);
			Connection cn = DriverManager.getConnection(dbUrl);
			Statement st = cn.createStatement();
			ResultSet rs;
			if (trainno != null) {
				query = "select " + columnName + " ," + trainno + " from " + tableName;

				rs = st.executeQuery(query);
				// out.print("<select>");
				while (rs.next()) {
					String station = rs.getString(columnName);

					String number = rs.getString(trainno);

					out.print("<option>" + station + " (" + number + " )" + "</option>");
				}
			} else {
				query = "select " + columnName + " from " + tableName;
				rs = st.executeQuery(query);
				// out.print("<select>");
				while (rs.next()) {
					String station = rs.getString(columnName);

					out.print("<option>" + station + "</option>");
				}
			}
			out.println("</select>");

			// Close database resources
			rs.close();
			st.close();
			cn.close();
		} catch (Exception e) {
			throw new JspException(e);
		}
		return SKIP_BODY;
	}
}