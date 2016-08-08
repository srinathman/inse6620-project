import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Counter;
import org.apache.hadoop.mapreduce.Mapper;

public class Job21SrcDstInse6620Mapper extends
		Mapper<Object, Text, IntWritable, Text> {

	private IntWritable thisKey = new IntWritable();

	@Override
	public void map(Object key, Text value, Context context)
			throws IOException, InterruptedException {
		String line = value.toString();
		String[] splitLine = line.split("\\t");
		String[] splitLine2 = splitLine[0].split(";") ;		
		
		if (splitLine2[0].equals("srcip_dstip")) {			
			thisKey.set(Integer.parseInt(splitLine[1]));
			context.write(thisKey, new Text(splitLine2[1]));
		}

	}

}
