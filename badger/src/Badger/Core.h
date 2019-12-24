#pragma once

#ifdef BADGER_PLATFORM_WINDOWS
    #ifdef BADGER_BUILD_DLL
        #define BADGER_API __declspec(dllexport)
    #else
        #define BADGER_API __declspec(dllimport)
    #endif
#elif BADGER_PLATFORM_LINUX
    #ifdef BADGER_BUILD_DLL
        #define BADGER_API __attribute__((visibility("default")))
    #else
        #define BADGER_API
    #endif
#endif

#ifdef BADGER_ENABLE_ASSERTS
    #define BADGER_ASSERT(x, ...) { if(!(x)) { BADGER_ERROR("Assertion Failed: {0}", __VA_ARGS__); __debugbreak(); } }
    #define BADGER_CORE_ASSERT(x, ...) { if(!(x)) { BADGER_CORE_ERROR("Assertion Failed: {0}", __VA_ARGS__); __debugbreak(); } }
#else
#define BADGER_ASSERT(x, ...)
#define BADGER_CORE_ASSERT(x, ...)
#endif

#define BIT(x) (1 << x)

#define BADGER_BIND_EVENT_FN(fn) std::bind(&fn, this, std::placeholders::_1)
