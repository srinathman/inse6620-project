import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.GenericOptionsParser;

public class Job21SrcDstInse6620 {

	public static void main(String[] args) throws Exception {
		Configuration conf = new Configuration();

		if (args.length != 2) {
			System.err.println("Usage: Job2Inse6620 <in> <out> ");
			System.exit(2);
		}

		Job job = Job.getInstance(conf, "INSE 6620 Job #2.1");
		job.setJarByClass(Job21SrcDstInse6620.class);
		job.setMapperClass(Job21SrcDstInse6620Mapper.class);
		// job.setCombinerClass( Inse6620Combinerclass) ;
		job.setReducerClass(Job21SrcDstInse6620Reducer.class); 

		job.setOutputKeyClass(IntWritable.class);
		job.setOutputValueClass(Text.class);

		FileInputFormat.addInputPath(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path(args[1]));

		System.exit(job.waitForCompletion(true) ? 0 : 1);

	}
}
