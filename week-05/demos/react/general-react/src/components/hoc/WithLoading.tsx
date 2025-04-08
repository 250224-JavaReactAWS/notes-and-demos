import { ComponentType, JSX } from 'react';

// Define types for the HOC's props
interface WithLoadingProps {
  isLoading: boolean;
}

// Define the HOC
function withLoading<T extends JSX.IntrinsicAttributes>(WrappedComponent: ComponentType<T>) {
  // Return a new component with the loading logic
  return ({ isLoading, ...props }: WithLoadingProps & T) => {
    if (isLoading) {
      return <div>Loading...</div>; // You can customize the loading component
    }

    // If not loading, render the wrapped component with the passed props
    return <WrappedComponent {...(props as unknown as T)} />;
  };
}

export default withLoading;