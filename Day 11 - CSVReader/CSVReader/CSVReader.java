/*.
 * Given a CSV file, we will read the data from the CSV file and parses each
 * line of the file. See the operations that are performed after reading the
 * file.
 *
 * @author Siva Sankar
 * @author Nemnous
 */
/**.
 * CSV reade class
 */
public class CSVReader {

    /**.
     * dataframe of type String[]
     */
    private String[] dataFrame;


    // Helpers are just for CheckStyle
    /**.
     *
     * @return String[] dataframe
     */
    public String[] getDataframe() {
        return this.dataFrame;
    }

    /**.
     *
     * @param df dataframe from file
     */
    public void setDataframe(final String[] df) {
        this.dataFrame = df;
    }
    /**.
     * This function is used to read the given csv File
     * ReadCSVFile class
     *
     * @param fileName - name of the given csv file
     */
    public void readCSV(final String fileName) {
        setDataframe(ReadCSVFile.readFile(fileName));
    }

    /**
     * The number of rows in the given data frame. Note: This shouldn't include
     * the coloumn labels.
     *
     * @return -1 if the Data set is empty
     */
    public int rowCount() {
        // TODo
        // Your code goes here....
        if (dataFrame.length == 0) {
            return -1;              // empty dataframe
        }

        return dataFrame.length - 1;
    }

    /**
     * This method returns the count of coloumns in a data Frame.
     * @return the count of columns in the dataset and -1 otherwise.
     */
    public int fieldCount() {
        // TODO
        // Your code goes here....
        if (dataFrame.length == 0) {
            return -1;              // empty dataframe
        }

        return dataFrame[0].split(",").length;
    }

    /**.
     * This method returns the name of the column based on the index
     * passed as a parameter
     *
     * @param index index of the coloumn starting from 1.
     * @return the column name based on the index and null otherwise.
     */
    public String getFieldName(final int index) {
        // TODO
        // Your code goes here....
        if (dataFrame.length == 0) {
            return null;                // empty dataframe
        }

        if (index < 0 || index > dataFrame[0].split(",").length) {
            return null;                // must be within no.of columns
        }

        return dataFrame[0].split(",")[index - 1];
    }


    /**
     * This method returns the row (array of values) based on the parameter
     * passed to the method.
     *
     * @param rowNumber given the Row of the row indexing from
     * 1. Exclude the column header row
     *
     * @return the string array containing the contents of the entire row.
     */
    public String[] getRow(final int rowNumber) {
        // TODO
        // Your code goes here....
        if (dataFrame.length == 0) {
            return null;                //for empty dataframe
        }

        if (rowNumber < 0 || rowNumber > dataFrame.length) {
            return null;                // must be within dataframe
        }

        return dataFrame[rowNumber].split(",");
    }

    /**
     * This method returns the rows (String[]) based on fromIndex and toIndex.
     * The fromIndex and toIndex should be in the range of the dataset lengths.
     *
     * @param fromIndex given from index
     * @param toIndex   given to index
     * @return String array containing rows starting from the fromindex to the
     *         toindex. Append the entire row
     */
    public String[] getRows(final int fromIndex, final int toIndex) {
        // TODO
        // Your code goes here....

        if (dataFrame.length == 0) {
            return null;                        // for a emty dataframe
        }

        if (fromIndex < 0 || toIndex < 0) {
            return null;                        // negatives cant be encouraged
        }

        if (fromIndex > toIndex) {         // (2 to 3 rows : OK) not 3 to 2 rows
            return null;
        }

        if (fromIndex > dataFrame.length || toIndex > dataFrame.length) {
            return null;                        //not beyond the dataframe
        }

        String[] rows = new String[toIndex - fromIndex];

        int r = 0;
        for (int i = fromIndex; i < toIndex; i++) {
            rows[r] = dataFrame[i];
            r++;
        }
        return rows;
    }

    /**
     * This method returns the column values based on particular column index.
     *
     * @param index index of the column
     * @return all the values of the column as a string array
     */
    public String[] getColumnValues(final int index) {
        // TODO
        // Your code goes here....

        if (dataFrame.length == 0) {
            return null;                // empty dataframe
        }

        if (index < 0 || index > dataFrame[0].split(",").length) {
            return null;                // must be within no.of columns
        }

        String[] columnValues = new String[dataFrame.length - 1];

        int r = 0;
        for (int i = 1; i < dataFrame.length; i++) {
            columnValues[r] = dataFrame[i].split(",")[index];
            r++;
        }
        return columnValues;
    }
}
