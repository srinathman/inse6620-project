import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Counter;
import org.apache.hadoop.mapreduce.Mapper;

public class Job1ParseCountInse6620Mapper extends
		Mapper<Object, Text, Text, IntWritable> {

	private final static IntWritable one = new IntWritable(1);
	private Text thisKey = new Text();

	static enum CountersEnum {
		INPUT_WORDS
	};

	@Override
	public void map(Object key, Text value, Context context)
			throws IOException, InterruptedException {
		String line = value.toString();

		// Parse Line
		// Ex: 1331901772.660000 cf5joy1mfrcwhu15u3 192.168.202.79 63805
		// 192.168.229.254 22041 tcp - - - - s0 - 0 s 1 44 0 0 (empty)
		// 'ts','uid','id.orig_h','id.orig_p','id.resp_h','id.resp_p','proto','service','duration','orig_bytes','resp_bytes','conn_state','local_orig','missed_bytes','history','orig_pkts','orig_ip_bytes','resp_pkts','resp_ip_bytes','tunnel_parents','threat','sample'
		// 0: 1331901772.660000
		// 1: Cv9PIe39xmBHZcRGRd
		// 2: 192.168.202.79
		// 3: 63806
		// 4: 192.168.229.254
		// 5: 24101

		String[] splitLine = line.split("\\t");


		// Source IP -> Destination IP combination
		thisKey.set( "srcip_dstip;" + splitLine[2] + "->" + splitLine[4]);
		context.write(thisKey, one);
		
		// Source IP
		thisKey.set( "srcip;" + splitLine[2]);
		context.write(thisKey, one);
		
		// Desction IP : Dest Port Combination
		thisKey.set( "dstip_dstport;" + splitLine[4] + ":" + splitLine[5]);
		context.write(thisKey, one);
		
		// userId
		thisKey.set( "uid;" +  splitLine[1]);
		context.write(thisKey, one);

	}

}
