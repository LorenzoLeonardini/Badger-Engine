# CMAKE generated file: DO NOT EDIT!
# Generated by "Unix Makefiles" Generator, CMake Version 3.12

# Delete rule output on recipe failure.
.DELETE_ON_ERROR:


#=============================================================================
# Special targets provided by cmake.

# Disable implicit rules so canonical targets will work.
.SUFFIXES:


# Remove some rules from gmake that .SUFFIXES does not remove.
SUFFIXES =

.SUFFIXES: .hpux_make_needs_suffix_list


# Suppress display of executed commands.
$(VERBOSE).SILENT:


# A target that is always out of date.
cmake_force:

.PHONY : cmake_force

#=============================================================================
# Set environment variables for the build.

# The shell in which to execute make rules.
SHELL = /bin/sh

# The CMake executable.
CMAKE_COMMAND = /usr/bin/cmake

# The command to remove a file.
RM = /usr/bin/cmake -E remove -f

# Escaping for special characters.
EQUALS = =

# The top-level source directory on which CMake was run.
CMAKE_SOURCE_DIR = /home/pianka/BadgerEngine

# The top-level build directory on which CMake was run.
CMAKE_BINARY_DIR = /home/pianka/BadgerEngine

# Include any dependencies generated for this target.
include CMakeFiles/badgerlib.dir/depend.make

# Include the progress variables for this target.
include CMakeFiles/badgerlib.dir/progress.make

# Include the compile flags for this target's objects.
include CMakeFiles/badgerlib.dir/flags.make

CMakeFiles/badgerlib.dir/badger/src/Test.cpp.o: CMakeFiles/badgerlib.dir/flags.make
CMakeFiles/badgerlib.dir/badger/src/Test.cpp.o: badger/src/Test.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/home/pianka/BadgerEngine/CMakeFiles --progress-num=$(CMAKE_PROGRESS_1) "Building CXX object CMakeFiles/badgerlib.dir/badger/src/Test.cpp.o"
	/usr/bin/c++  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles/badgerlib.dir/badger/src/Test.cpp.o -c /home/pianka/BadgerEngine/badger/src/Test.cpp

CMakeFiles/badgerlib.dir/badger/src/Test.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/badgerlib.dir/badger/src/Test.cpp.i"
	/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E /home/pianka/BadgerEngine/badger/src/Test.cpp > CMakeFiles/badgerlib.dir/badger/src/Test.cpp.i

CMakeFiles/badgerlib.dir/badger/src/Test.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/badgerlib.dir/badger/src/Test.cpp.s"
	/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S /home/pianka/BadgerEngine/badger/src/Test.cpp -o CMakeFiles/badgerlib.dir/badger/src/Test.cpp.s

# Object files for target badgerlib
badgerlib_OBJECTS = \
"CMakeFiles/badgerlib.dir/badger/src/Test.cpp.o"

# External object files for target badgerlib
badgerlib_EXTERNAL_OBJECTS =

bin-lib/libbadgerlib.a: CMakeFiles/badgerlib.dir/badger/src/Test.cpp.o
bin-lib/libbadgerlib.a: CMakeFiles/badgerlib.dir/build.make
bin-lib/libbadgerlib.a: CMakeFiles/badgerlib.dir/link.txt
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --bold --progress-dir=/home/pianka/BadgerEngine/CMakeFiles --progress-num=$(CMAKE_PROGRESS_2) "Linking CXX static library bin-lib/libbadgerlib.a"
	$(CMAKE_COMMAND) -P CMakeFiles/badgerlib.dir/cmake_clean_target.cmake
	$(CMAKE_COMMAND) -E cmake_link_script CMakeFiles/badgerlib.dir/link.txt --verbose=$(VERBOSE)

# Rule to build all files generated by this target.
CMakeFiles/badgerlib.dir/build: bin-lib/libbadgerlib.a

.PHONY : CMakeFiles/badgerlib.dir/build

CMakeFiles/badgerlib.dir/clean:
	$(CMAKE_COMMAND) -P CMakeFiles/badgerlib.dir/cmake_clean.cmake
.PHONY : CMakeFiles/badgerlib.dir/clean

CMakeFiles/badgerlib.dir/depend:
	cd /home/pianka/BadgerEngine && $(CMAKE_COMMAND) -E cmake_depends "Unix Makefiles" /home/pianka/BadgerEngine /home/pianka/BadgerEngine /home/pianka/BadgerEngine /home/pianka/BadgerEngine /home/pianka/BadgerEngine/CMakeFiles/badgerlib.dir/DependInfo.cmake --color=$(COLOR)
.PHONY : CMakeFiles/badgerlib.dir/depend

