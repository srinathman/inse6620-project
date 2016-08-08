import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class Job24UidInse6620Reducer extends
		Reducer<IntWritable, Text, Text, IntWritable> {

    // Accumulator
	private IntWritable result = new IntWritable();

	public void reduce(IntWritable key, Iterable<Text> values, Context context)
			throws IOException, InterruptedException {

		if (key.get() > 50) {
			System.out.println(key);
			for (Text t : values) {		
				context.write(t, key);
			}
		}

	}
}