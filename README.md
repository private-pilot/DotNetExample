# Getting started

## Installing and setting up dnx runtime

Download and install rc1 from [their github repo](https://github.com/aspnet/dnx/releases) or via [direct link here](https://web.archive.org/web/20160513111915/http://go.microsoft.com/fwlink/?LinkId=627627)

Then run

`
dnvm upgrade
`

Make sure to use 1.0.0-rc1-update1 of the dnx runtime. The `upgrade` command should take care of that, but you can also double check using 

`
dnvm list
`

And assign the current dnx runtime using

`
dnvm use <version>
`

Optionally, you can specify the runtime type using

`
dnvm use -r <runtime>
`

This is useful if you have multiple runtimes of the same version but different runtime type. Architecture can be specified the same way. For a full list of options, use

`
dnvm use
`

## Starting the application

Navigate to /src/ContosoBooks and run

`
dnx web
`

The site should be accessible on http://localhost:5000

To stop, hit `Ctrl` and `C`

## Running NUnit tests

__Note__: NUnit has preliminary (read: hacky) support for .NET 5, which the ContosoBooks project is written under. NUnitLite (a CLI runner of NUnit) is used to trigger the tests via command line. Upgrading to .NET Core (i.e. rc2) **will** break the tests.

Navigate to test/ContosoBooksTest and run

`
dnx test
`

After the tests are done, any failures will be reported in the console. Adding Jenkins support for passing or failing jobs can be easily done. While NUnitLite does not support redirecting output under dnx, you can use

`
dnx test > out.txt
`

And then use `findstr` on the output file

`
findstr /C:"Overall result: Passed" out.txt
`

When a test fails, findstr will fail its search and set the environment variable ERROR_LEVEL to 1. This will allow Jenkins to mark the build as failed (as success requires 0)