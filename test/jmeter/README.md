# Usage

## Installation and running

If needed, first [download and install Java](http://java.com/en/download/mac_download.jsp). Then download and unarchive [JMeter](http://jmeter.apache.org/download_jmeter.cgi) somewhere convenient. Note that any environment or shell variables must be created on your own. 

Run the script using

`
jmeter -n -t ContosoBooks.jmx
`

Substitute the filename as necessary if there are other scripts to run.

## Script configuration

Make sure to configure the script prior to running it as necessary. It is currently set to http://localhost:5000 and will only run for one iteration. JMeter allows tests to receive additional user-defined variables as well, which can help make running from the command line more easily. More information is available from [JMeter's parameterising tests](http://jmeter.apache.org/usermanual/best-practices.html#parameterising_tests) docs
