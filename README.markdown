remote interpreter

Separated into three parts : 
Server : The centralised "request dispatcher".
Infiltrator : the place that runs the interpreter. Connects to the server.
Client : The person that wants the interpreter. Connects to the infiltrator through server.

Protocole : 
The infiltrator and client will communicate with the server through one-line strings, and arguments will be separated by ":::". Multiline might be supported eventually.

For instance, "rs:::println('hi')"
Will split into ["rs", "println('hi')"].

The "opcode" is defined by the first argument. They are not the same if it's a client or an infiltrator.
Here is a list of opcodes : 

# Opcodes from server : #
* e : error
    * Sends two additional arguments : 
        * args[1] : The name of error that happened.
        * args[2] : The description.
* sl : Successfully logged in.
    * Sends one additional arguments : 
        * args[1] : a coma-separated list of machines.
* ro : redirected output
    * The redirected string from infiltrator 
    * WHY : To ease things up, infiltrators change the System.out to the socket. As such, we can't append an opcode to those (at least not for now).

# Opcodes from client : #
* l : login. 
    * Takes two additional arguments : 
        * args[1] : The username to use (that's to avoid people using our protocole).
        * args[2] : The password to use (same).
    * Possible return opcodes : 
        * e
            * IllegalArgumentException
                * Didn't send enough arguments/too many arguments
            * InvalidUserPassException
                * The username or password are wrong.
        * sl
            * Successfully logged in.

* rs : run string

# Opcodes from infiltrator : #
* ci : Create Infiltrator
    * Takes two additional arguments : 
        * args[1] : The name of the machine
        * args[2] : A coma separated list of engines.
