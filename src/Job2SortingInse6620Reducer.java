import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class Job2SortingInse6620Reducer extends
		Reducer<IntWritable, Text, Text, IntWritable> {

    // Accumulator
	private IntWritable result = new IntWritable();

	public void reduce(IntWritable key, Iterable<Text> values, Context context)
			throws IOException, InterruptedException {

		// System.out.println(key + "=" + value );
		// if (key.get() > 300) {
		// context.write(key, value);
		// }

		if (key.get() > 50) {
			System.out.println(key);
			for (Text t : values) {
				// System.out.print(".");
				IntWritable i = new IntWritable(key.get() * 10);
				context.write(t, key);
			}
		}
		// System.out.println();
		// context.write( i, new Text("aa"));
		// context.write( new IntWritable(9999) , new Text("aaa") );

	}
}