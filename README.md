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