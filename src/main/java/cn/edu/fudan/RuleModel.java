package cn.edu.fudan;

/**
 * Created by FengSi on 2017/06/06 at 14:46.
 */
public class RuleModel {
    private String tableName;
    private String leftColumn;
    private String rightColumn;

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getLeftColumn() {
        return leftColumn;
    }

    public void setLeftColumn(String leftColumn) {
        this.leftColumn = leftColumn;
    }

    public String getRightColumn() {
        return rightColumn;
    }

    public void setRightColumn(String rightColumn) {
        this.rightColumn = rightColumn;
    }

}
