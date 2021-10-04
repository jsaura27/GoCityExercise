package Data;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;

import java.io.IOException;


public class CSVReaderTest {

    @Test
    public void productReaderIsNotEmpty() throws IOException {
        Assert.assertTrue("The reader gets elements", !CSVReader.productReader().isEmpty());

    }
    @Test
    public void productReaderHasAllTheElements() throws IOException {
        Assert.assertTrue("The reader gets elements", CSVReader.productReader().size() == 34);

    }
    @Test
    public void categoryReaderIsNotEmpty() throws IOException {
        Assert.assertTrue("The reader gets elements", !CSVReader.categoryReader().isEmpty());

    }
    @Test
    public void categoryReaderHasAllTheElements() throws IOException {
        Assert.assertTrue("The reader gets elements", CSVReader.categoryReader().size() == 7);

    }


}
