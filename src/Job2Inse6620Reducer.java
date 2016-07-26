import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class Job2Inse6620Reducer extends
		Reducer<IntWritable, Text, IntWritable, Text> {

	private IntWritable result = new IntWritable();

	public void reduce(IntWritable key, Text value, Context context)
			throws IOException, InterruptedException {

		  
	  System.out.println(key + "=" + value );	
		if (key.get() > 300) {
			context.write(key, value);
		}
		
	}
}